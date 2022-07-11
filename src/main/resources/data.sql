-- INSERT IGNORE INTO
--     tbl_role (
--         role_id,
--         role_name,
--         role_decription
--     )
-- VALUES
--     (   
--         1,
--         'ROLE_CUSTOMER',
--         'customer'
--     ),
--     (   
--         2,
--         'ROLE_DELIVERY',
--         'delivery'
--     ),
--     (   
--         3,
--         'ROLE_OWNER',
--         'owner'
--     ),
--     (   
--         4,
--         'ROLE_ADMIN',
--         'admin'
--     );
INSERT
    IGNORE INTO tbl_category (category_id, category_name)
VALUES
    (1, 'khmer food'),
    (2, 'chinese food'),
    (3, 'thai food');

INSERT
    IGNORE INTO food_app.tbl_user (
        user_id,
        fullname,
        phone,
        password,
        `role`,
        email,
        address
    )
VALUES
(
        '1',
        'admin',
        '0123456789',
        'password',
        'ROLE_ADMIN',
        'admin',
        'HQ'
    ); 