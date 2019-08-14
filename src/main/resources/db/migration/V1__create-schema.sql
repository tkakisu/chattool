CREATE TABLE IF NOT EXISTS chat (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    username NVARCHAR(60) NOT NULL,
    message NVARCHAR(140) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(3)
);

INSERT INTO chat (username, message) VALUES ('test1', 'こんにちはこんにちは！');
INSERT INTO chat (username, message) VALUES ('test2', '折り返しの' || CHAR(13) || CHAR(10) || 'ある文章');
