    CREATE TABLE IF NOT EXISTS tbl_user(
        id INT(11) PRIMARY KEY AUTO_INCREMENT
        ,name VARCHAR(255) COMMENT '氏名'
        ,code VARCHAR(255) COMMENT ' ユーザコード'
        ,password VARCHAR(255) COMMENT 'パスワード'
        ,type INT(1) COMMENT 'ユーザタイプ（0:購入ユーザ,1:出品者）'
        ,created_at DATETIME COMMENT ' 作成日時'
        ,upudate_at DATETIME COMMENT '  更新日時'
    )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ユーザテーブル';

    CREATE TABLE IF NOT EXISTS tbl_item (
        id INT(11) PRIMARY KEY AUTO_INCREMENT
        ,product_code VARCHAR(255) UNIQUE COMMENT '製品コード'
        ,category INT(1) COMMENT 'カテゴリ(0:書籍,1:ホビー,2:生活用品)'
        ,product_name VARCHAR(255) COMMENT '商品名'
        ,create_user_id INT(12) COMMENT '作成ユーザID'
        ,created_at DATETIME COMMENT '作成日時'
        ,update_user_id INT(12) COMMENT ' 更新ユーザID'
        ,upudate_at DATETIME COMMENT '更新日時'
    )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品マスタ';

    CREATE TABLE IF NOT EXISTS tbl_sale_item(
        id INT PRIMARY KEY AUTO_INCREMENT
        ,tbl_user_id INT(11) COMMENT '出品者ID'
        ,product_code VARCHAR(255) COMMENT '製品コード'
        ,product_name VARCHAR(255) COMMENT '製品名'
        ,sale_price INT(11) COMMENT '販売価格'
        ,item_condition INT(1) COMMENT '商品コンディション(0:新品,1:良好,2:可)'
        ,sale_date DATE COMMENT '販売日'
        ,sale_status INT(1) DEFAULT 0 COMMENT '販売状況(0:販売中,1:販売完了)'
        ,created_at DATETIME COMMENT '作成日時'
        ,create_user_id INT(12) COMMENT '作成ユーザID'
        ,upudated_at DATETIME COMMENT '更新日時'
        ,update_user_id INT(12) COMMENT ' 更新ユーザID'
    )ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='出品アイテム';