INSERT INTO u_biz_role (id, name, name_zh, description, status, merchant_id, create_user_id, create_time,
                        update_user_id, update_time, deleted, version)
VALUES (775402379755073536, 'ROLE_user', '店员', '普通用户', 1, 1, null, null, null, '2020-11-09 16:52:14', 0, 0);

INSERT INTO u_biz_role (id, name, name_zh, description, status, merchant_id, create_user_id, create_time,
                        update_user_id, update_time, deleted, version)
VALUES (775413365652271104, 'ROLE_admin', '管理员', '商家管理员', 1, 1, null, null, null, '2020-11-09 17:35:54', 0, 0);

INSERT INTO u_biz_role (id, name, name_zh, description, status, merchant_id, create_user_id, create_time,
                        update_user_id, update_time, deleted, version)
VALUES (1, 'ROLE_user', '店员', '普通用户', 1, 1, null, null, null, '2020-11-09 16:52:14', 0, 0);

INSERT INTO u_biz_permission (id, parent_id, name, level, icon, type, url, method, status, merchant_id,
                              create_user_id, create_time, update_user_id, update_time, deleted, version)
VALUES (775411429637042176, null, '用户管理', '1', null, null, '/bizUser/**', null, null, 1, null, null, null,
        '2020-11-09 17:28:12', 0, 0);

INSERT INTO u_biz_role_permission (id, role_id, permission_id, merchant_id, create_user_id, create_time,
                                   update_user_id, update_time, deleted, version)
VALUES (1, 775402379755073536, 775411429637042176, 1, null, '2020-11-09 22:15:10', null, '2020-11-09 22:15:10', 0, 0);