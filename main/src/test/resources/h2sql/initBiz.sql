INSERT INTO u_biz_role (id, name, name_zh, description, status, merchant_id, create_user_id, create_time,
                        update_user_id, update_time, deleted, version)
VALUES (775402379755073536, 'ROLE_USER', '店员', '普通用户', 1, 1, null, null, null, '2020-11-09 16:52:14', 0, 0);

INSERT INTO u_biz_role (id, name, name_zh, description, status, merchant_id, create_user_id, create_time,
                        update_user_id, update_time, deleted, version)
VALUES (775413365652271104, 'ROLE_ADMIN', '管理员', '商家管理员', 1, 1, null, null, null, '2020-11-09 17:35:54', 0, 0);

INSERT INTO u_biz_role (id, name, name_zh, description, status, merchant_id, create_user_id, create_time,
                        update_user_id, update_time, deleted, version)
VALUES (123413365652243104, 'ROLE_ADMIN', '管理员', '商家管理员', 1, 1, null, null, null, '2020-11-09 17:35:54', 0, 0);

INSERT INTO u_biz_permission (id, parent_id, name, level, icon, type, url, method, status, merchant_id,
                              create_user_id, create_time, update_user_id, update_time, deleted, version)
VALUES (775411429637042176, null, '用户管理', '1', null, null, '/bizUser/**', null, null, 1, null, null, null,
        '2020-11-09 17:28:12', 0, 0);

INSERT INTO u_biz_role_permission (id, role_id, permission_id, merchant_id, create_user_id, create_time,
                                   update_user_id, update_time, deleted, version)
VALUES (1, 775402379755073536, 775411429637042176, 1, null, '2020-11-09 22:15:10', null, '2020-11-09 22:15:10', 0, 0);

INSERT INTO u_biz_user (id, username, password, icon, phone, email, nick_name, login_time, status, merchant_id,
                        create_user_id, create_time, update_user_id, update_time, deleted, version)
VALUES (775412006114766848, 'tom', '$2a$10$eqfBk4Py6KQuL1Vw4cxrq.xTcxBFUYBBNnCd4U3NZ4Z12sWnEMzTm', null, null,
        null, '张三', '2020-11-09 17:30:29', null, 1, null, null, null, '2020-11-09 17:30:29', 0, 0);

INSERT INTO u_biz_user_role (id, user_id, role_id, merchant_id, create_user_id, create_time, update_user_id,
                             update_time, deleted, version)
VALUES (1, 775412006114766848, 775413365652271104, 1, null, null, null, null, 0, 0);