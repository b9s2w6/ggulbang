-- 장바구니 조회
SELECT basketNo, userId, aptCode
	FROM happyhouse.basket
    WHERE userId = "temp01";
    
-- 장바구니 상세 조회
SELECT basketNo, userId, aptCode
	FROM happyhouse.basket
    WHERE userId = "temp01"
		AND aptCode = 11110000000007;
        
-- 장바구니 입력
INSERT INTO basket(userId, aptCode) 
	VALUES ('temp01',11110000000015);
    
-- 장바구니 삭제
DELETE FROM basket
	WHERE userId = "temp01"
		AND aptCode = 11110000000007;