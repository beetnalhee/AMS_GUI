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
[코드보기](https://github.com/beetnalhee/AMS/tree/main/project_ams/src/com/ezen/ams/bin)


계좌종류를 마이너스 계좌로 선택하면, enable되어져있던 대출금액 textfield 가 활성화된다.


#### 1. Java 코드 실행화면 
<img src="https://github.com/beetnalhee/AMS/assets/151362604/3114df5b-da66-4bcd-9805-ff5a4179dd12" width="400" height="300"/></br>
#### 2. 계좌 생성 (입출금 계좌) 
<img src="https://github.com/beetnalhee/AMS/assets/151362604/7a0d35c8-5524-46a1-a01f-5a9f9f7d7199" width="400" height="300"/></br>
#### 3. 계좌 생성 (마이너스 계좌) 
<img src="https://github.com/beetnalhee/AMS/assets/151362604/3057e86a-c560-4a8a-a1dc-cf10e7020659" width="400" height="300"/></br>
#### 4. 계좌 목록 출력
<img src="https://github.com/beetnalhee/AMS/assets/151362604/ffe4aa50-2fd8-4ae7-ba9a-c4a73db1819a" width="400" height="300"/></br>
#### 5. 출금 
##### 1111-1111 계좌에서 10만원 출금하여 잔액 90만원으로 변경
<img src="https://github.com/beetnalhee/AMS/assets/151362604/63405347-188f-4269-bb91-e742822fa9cd" width="400" height="300"/></br>
#### 6. 검색 
##### 2222-2222 에 해당하는 계좌 검색, 출력
<img src="https://github.com/beetnalhee/AMS/assets/151362604/2b6f5cdb-2139-4e17-8d6e-c7b81422ee9e" width="400" height="300"/></br>
#### 7. 계좌삭제
##### 1111-1111 계좌 삭제 후, 목록 출력하면 1111-1111 계좌가 없어진 것을 확인 할 수 있음 
<img src="https://github.com/beetnalhee/AMS/assets/151362604/80d5c8dd-5f20-4624-8058-67850e32e298" width="400" height="300"/></br>


