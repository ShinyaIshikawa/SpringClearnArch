/*ユーザマスタ*/
INSERT INTO tbl_user(name,code,password,type,created_at,upudate_at) 
VALUES('Yamada Taro','t2o','$2a$08$KiHI0soxE4kFnPWFTEFDg.5DroSnZuAFw7/3t9vfdJWpNbrTzvOA6',0,NOW(),NOW()),
('Suzuki Hanako','ha4o','$2a$08$iiZedbVURnfTBslJiMNcF.KrxZ.gumwnR3H08qTgDEQv1w.GCoH9e',1,NOW(),NOW()),
('Isono Katsuo','k4o','$2a$08$oWAT8h.El3NLBTJK5mIlnOungq1OK.UTHX4KKreMvB5AUTbyGEhra',0,NOW(),NOW()),
('Alice','a3e','$2a$08$ug4Wz3oXPxFostrOTAZ5jePq9ThEq0TgHrjjfcZzDKfVbq2fR6wi6',1,NOW(),NOW()),
('Bob','b1b','$2a$08$4rVSp1pOHEIhCTn6DNTWauwyRUR6Qa1246znq.VFkZ51mAej5oWCW',0,NOW(),NOW()),
('Carol','C3l','$2a$08$4n63q0eQsxN1nZJtKyqViuI1Y9MdpER8nm6aLlf36plIKLTlvrU9S',1,NOW(),NOW());

/*商品マスタ（ユーザ共通）製品コードは10桁のランダム文字列*/
INSERT INTO tbl_item(product_code,category,product_name,create_user_id,created_at,update_user_id,upudate_at) 
VALUES(SUBSTRING(MD5(RAND()), 1, 10),0,'ハリー・ポッターと賢者の石(1)',1,NOW(),1,NOW()),
(SUBSTRING(MD5(RAND()), 1, 10),0,'ハリー・ポッターと賢者の石(2)',2,NOW(),2,NOW()),
(SUBSTRING(MD5(RAND()), 1, 10),0,'ハリー・ポッターと賢者の石(3)',3,NOW(),3,NOW()),
(SUBSTRING(MD5(RAND()), 1, 10),0,'ハリー・ポッターと賢者の石(4)',4,NOW(),4,NOW()),
(SUBSTRING(MD5(RAND()), 1, 10),0,'ハリー・ポッターと賢者の石(5)',5,NOW(),5,NOW()),
(SUBSTRING(MD5(RAND()), 1, 10),0,'リーダブルコード',1,NOW(),1,NOW()),
(SUBSTRING(MD5(RAND()), 1, 10),0,'ドメイン駆動開発',2,NOW(),2,NOW()),
(SUBSTRING(MD5(RAND()), 1, 10),0,'クリーンアーキテクチャー',3,NOW(),3,NOW()),
(SUBSTRING(MD5(RAND()), 1, 10),1,'Nintendo Switch',4,NOW(),4,NOW()),
(SUBSTRING(MD5(RAND()), 1, 10),1,'スマッシュブラザーズ',5,NOW(),5,NOW()),
(SUBSTRING(MD5(RAND()), 1, 10),1,'PS4',1,NOW(),1,NOW()),
(SUBSTRING(MD5(RAND()), 1, 10),2,'体重計',1,NOW(),1,NOW()),
(SUBSTRING(MD5(RAND()), 1, 10),2,'掃除機',1,NOW(),1,NOW()),
(SUBSTRING(MD5(RAND()), 1, 10),2,'体温計',1,NOW(),1,NOW()),
(SUBSTRING(MD5(RAND()), 1, 10),2,'ハンドソープ',1,NOW(),1,NOW());

/*出品アイテム　商品マスタをベースにランダムデータを作成*/
INSERT INTO tbl_sale_item(
    tbl_user_id,
    product_code,
    product_name,
    sale_price,
    item_condition,
    sale_date,
    sale_status,
    created_at,
    create_user_id,
    upudated_at,
    update_user_id
)
SELECT
    CEIL(RAND()*6),
    t1.product_code,
    t1.product_name,
    CEIL(RAND()*18000 + 2000), /* 2000~20000 */
    FLOOR(RAND()*3),
    DATE_ADD('2018-10-01', INTERVAL 180*rand() DAY),
    FLOOR(RAND()*2),
    NOW(),
    CEIL(RAND()*6),
    NOW(),
    CEIL(RAND()*6)
FROM tbl_item t1,tbl_item t2,tbl_item t3;