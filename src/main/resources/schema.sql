    CREATE TABLE IF NOT EXISTS tbl_user(
        id INT(11) PRIMARY KEY AUTO_INCREMENT
        ,name VARCHAR(255) COMMENT '氏名'
        ,code VARCHAR(255) COMMENT ' ユーザコード'
        ,password VARCHAR(255) COMMENT 'パスワード'
        ,type INT(1) COMMENT 'ユーザタイプ（0:購入ユーザ,1:出品者）'
        ,created_at DATETIME COMMENT ' 作成日時'
        ,upudate_at DATETIME COMMENT '  更新日時'
    )COMMENT='ユーザテーブル';

    CREATE TABLE IF NOT EXISTS tbl_item (
        id INT(11) PRIMARY KEY AUTO_INCREMENT
        ,product_code VARCHAR(255) UNIQUE COMMENT '製品コード'
        ,category INT(1) COMMENT 'カテゴリ(0:書籍,1:ホビー,2:生活用品)'
        ,name VARCHAR(255) COMMENT '商品名'
        ,created_at DATETIME COMMENT '作成日時'
        ,created_user_id INT(12) COMMENT '作成ユーザID'
        ,upudate_at DATETIME COMMENT '更新日時'
        ,updated_user_id INT(12) COMMENT ' 更新ユーザID'
    )COMMENT='商品マスタ';

    CREATE TABLE IF NOT EXISTS tbl_sale_item(
        id INT PRIMARY KEY AUTO_INCREMENT
        ,tbl_user_id INT(11) COMMENT '出品者ID'
        ,product_code VARCHAR(255) COMMENT '製品コード'
        ,sale_price INT(11) COMMENT '販売価格'
        ,item_condition INT(1) COMMENT '商品コンディション(0:新品,1:良好,2:可)'
        ,sale_date DATE COMMENT '販売日'
        ,created_at DATETIME COMMENT '作成日時'
        ,created_user_id INT(12) COMMENT '作成ユーザID'
        ,upudate_at DATETIME COMMENT '更新日時'
        ,updated_user_id INT(12) COMMENT ' 更新ユーザID'
    )comment='出品アイテム';