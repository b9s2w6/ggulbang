# 관통 프로젝트

## 컨셉 : 부동산 실거래

[DB 설명]
product : 판매자가 보유하고 있는 매물
basket : 구매자의 장바구니

패키지 설명
house : 매물 관련
deal : 매매 (거래) 관련
basket : 장바구니 관련

1. 요구사항 정리
   1. 주택 실거래가 검색 - 물품 리스트
      - house/list (1) // GET
      - house/regist (2) // POST
      - house/detail (3) - 구매 버튼 // GET
      - house/update (-)
      - house/delete (-)
   2. 회원관리 (-)
   3. 로그인 관리 (-)
   4. 구매 기능 (3) - /deal
      - 장바구니
        - 회원 ID - aptNo 매칭 장바구니
        - 담은 시간 -
        - **기능**
          - 장바구니 조회 :
          - 장바구니 추가 :
          - 장바구니 삭제 :
          - 장바구니 상세조회 → house/detail
          -
      - 매매 시스템
        - 거래완료시, 구매자의 물품 리스트에 부동산 물품 추가
          - 판매자의 물품 리스트에 부동산 물품 삭제
        1. 물품을 구매자가 구매 버튼 클릭
        2. 기업에 입금확인 시 판매자에게 노티 (기업 계좌 하나만 알려주면 됨)
        3. 입금 완료시, 판매자에게 동의/거절 버튼 표기
        4. 이후 작업에 따라 부동산 물품 삭제 or 구매 취소 진행
        5. 번외) 포인트 충전 식으로 현금처럼 쓸수있게 해주는 기능
        - **기능**
          - 구매
          - 입금 확인
          - 판매자에게 알려주고
          - 거래 성사 or 취소
          - 물품 소유자 변경
   5. 채팅 기능 (당사자 두명)
   6. 연동 로그인 (구글)
   7. 번외 땅 투기 (주식처럼)
2. 화면 구상
3. REST 설계
   - /house/
   - 어떤걸 Json으로 보낼건지 등등을 정하기

[레퍼런스]

- 카카오맵 : https://soa-memo.tistory.com/41
