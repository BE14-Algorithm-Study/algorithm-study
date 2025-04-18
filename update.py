#!/usr/bin/env python

import os
import re
from urllib import parse

HEADER = """# 🐶 BE14 알고리즘 스터디
## 목차
"""

def main():
    content = ""  # content를 HEADER로 초기화
    toc = []  # 목차 저장 리스트
    directories = set()  # 중복 방지용 set
    names = ['성연', '민수', '석희', '민종', '준규', '동한', '혜민', '석현']
    site_link = "https://www.acmicpc.net/problem/"

    for root, dirs, files in os.walk("."):
        dirs.sort()
        if root == ".":
            for dir in (".git", ".github"):
                if dir in dirs:
                    dirs.remove(dir)
            continue

        if "Programmers" in root:
            # ✅ Programmers 문제는 바로 "./Programmers/문제이름"
            parts = root.split(os.sep)
            if len(parts) == 3 and parts[1] == "Programmers":
                category = "Programmers"
                problem_name = parts[2]
                folder_link = parse.quote(os.path.join(root))

                if category not in directories:
                    toc.append(f"### [{category}](#-programmers)")
                    content += f"# 📢 {category}\n"
                    content += "| 문제 | &nbsp;&nbsp;깃&nbsp;&nbsp; | " + " | ".join(names) + " |\n"
                    content += "| ----- | :-----: | " + " | ".join(["-----"] * len(names)) + " |\n"
                    directories.add(category)

                content += f"|{problem_name}|[링크]({folder_link})|"
                for name in names:
                    checked = "✔" if any(name in file for file in files) else ""
                    content += f"{checked}|"
                content += "\n"
            continue  # 다음 root로


        # 문제 유형 폴더 (ex : "Bruteforce")
        category = os.path.basename(os.path.dirname(root))
        # 문제 번호 폴더 (예: "Boj1000")
        directory = os.path.basename(root)

        if category == "." or directory == "." or directory in [".git", ".github", "images"]:
            continue

        # ✅ 1. BOJ 문제 처리
        if directory.startswith("Boj"):
            match = re.match(r"Boj(\d+)", directory)
            if match:
                problem_number = match.group(1)
                folder_link = parse.quote(os.path.join(root))
                problem_link = f"{site_link}{problem_number}"

                # 새로운 유형이면 제목 추가 & 목차에 반영
                if category not in directories:
                    # 목차에 추가
                    toc_link = category.replace(" ", "-").lower()  # Markdown 내부 링크 변환
                    toc.append(f"### [{category}](#-{toc_link})")

                    # 본문에 제목 추가
                    content += f"# 📢 {category}\n"
                    content += "| 문제 | &nbsp;&nbsp;깃&nbsp;&nbsp; | 성연 | 민수 | 석희 | 민종 | 준규 | 동한 | 혜민 | 석현 |\n"
                    content += "| ----- | :-----: | ----- | ----- | ----- | ----- | ----- | ----- | ----- | ----- |\n"
                    directories.add(category)

                # 표에 문제 번호 추가
                content += f"|[{problem_number}]({problem_link})|[링크]({folder_link})|"

                # 해당 문제를 푼 사람 체크
                for name in names:
                    checked = "✔" if any(name in file for file in files) else ""
                    content += f"{checked}|"

                content += "\n"

    # 목차를 content 맨 앞부분에 추가
    content = HEADER + "\n".join(toc) + "\n\n" + content

    with open("README.md", "w") as fd:
        fd.write(content)

if __name__ == "__main__":
    main()
