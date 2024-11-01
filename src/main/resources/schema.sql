CREATE TABLE IF NOT EXISTS token
(
    id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    token
    VARCHAR
(
    255
) NOT NULL,
    device_id VARCHAR
(
    255
) NOT NULL UNIQUE
    );