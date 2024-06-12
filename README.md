# 💵 AMS_GUI
GUI Account Management System  
Java AWT 를 활용한 계좌 관리 시스템
<br />
<br />
<br />
# 📃 프로젝트 정보
* 제작기간 : 2024.01.29 ~ 02.02
* back-end : Java
* front-end : Java AWT (Abstract Window Toolkit)
 - 기존의 AMS프로젝트의 불편하고 부족했던 기능을 업그레이드하였다.
 - **GUI**를 활용하여 사용자 편의성 증가
 - **유효성 검사** 적용(동일 계좌번호 생성불가, 타입 및 형식 확인 등)

<br />

# 🔑 구현내용

### 1. GUI(AWT)가 적용된 계좌관리 기능을 구현 

* 계좌 관리 프로그램을 실행하면 각 메뉴를 사용할 수 있다. 

* 메뉴 :</br>
1.신규등록(입출금/마이너스계좌중 선택)</br>
2.전체계좌목록 조회</br>
3.예금 및 출금</br>
4.계좌번호로검색</br>
5.계좌삭제</br>
6.계좌 정렬(예금주/예금액/계좌번호)</br>
<br />
      
      
# ⌨️ 코드
[주요코드보기](https://github.com/beetnalhee/AMS_GUI/blob/main/AccountFrame.java)




#### 1. AWT 실행화면 - 입출금 계좌 생성
<img src="https://github.com/beetnalhee/AMS_GUI/assets/151362604/1b3b43c6-e556-4d0f-829d-fb218842f7e8" width="450" height="350"/></br>
#### 2. 신규생성 유효성 검사 - 이미 존재하는 계좌번호와 비교
비교 후, 존재하면 이미 존재하는 계좌번호라는 메세지 출력

<img src="https://github.com/beetnalhee/AMS_GUI/assets/151362604/f33a7839-fd1e-4a4a-ae18-1e2d08d690de" width="450" height="300"/></br>
#### 3. 검색 유효성 검사 - 검색한 계좌번호가 있다면 출력, 없다면 없다는 메세지 출력

<img src="https://github.com/beetnalhee/AMS_GUI/assets/151362604/914dce98-db06-45dd-9425-997fb4b5fb45" width="450" height="300"/></br>

#### 4. 전체 계좌 목록 출력
<img src="https://github.com/beetnalhee/AMS_GUI/assets/151362604/5c3ad6b2-d44e-4174-b618-96dba073dd15" width="450" height="350"/></br>

#### 5. 계좌 유효성 
##### 계좌번호, 비밀번호, 입금 및 대출금액은 숫자, 그외는 텍스트로 표기
<img src="https://github.com/beetnalhee/AMS_GUI/assets/151362604/2cffb193-b716-4ecc-947c-522cece8e17c" width="400" height="300"/></br>

#### 6. Textfield 유효성 검사 
##### 계좌종류를 마이너스 계좌로 선택하면, enable되어져있던 대출금액 textfield 가 활성화된다.
<img src="https://github.com/beetnalhee/AMS_GUI/assets/151362604/43cf3aa0-1e86-46b7-b9a0-ede9417b4ab0" width="400" height="300"/></br>
<img src="https://github.com/beetnalhee/AMS_GUI/assets/151362604/8e800652-63ca-4ee0-8fc3-2d60c1a5462d" width="400" height="300"/></br>
#### 7. 정렬(잔액/예금주/계좌번호별)
<img src="https://github.com/beetnalhee/AMS_GUI/assets/151362604/5e458b81-2dfd-4cd8-a11a-8c4245a0293e" width="450" height="200"/></br>
<img src="https://github.com/beetnalhee/AMS_GUI/assets/151362604/9ee35084-f4eb-44dc-b35a-b93369bd3ac9" width="450" height="200"/></br>
<img src="https://github.com/beetnalhee/AMS_GUI/assets/151362604/22d2b6c5-7769-437e-8790-2a4ffe8b3220" width="450" height="200"/></br>




