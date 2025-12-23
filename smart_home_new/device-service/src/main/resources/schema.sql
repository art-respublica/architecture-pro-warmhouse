CREATE TABLE IF NOT EXISTS sensors
(
    id           int not null primary key,
    sensor_name  VARCHAR(254),
    device_type  VARCHAR(254),
    location     VARCHAR(254),
    sensor_value int,
    unit         VARCHAR(254),
    status       VARCHAR(254),
    created_at   date,
    updated_at   date
);

---

CREATE TABLE IF NOT EXISTS houses
(
    id       int not null primary key,
    location VARCHAR(254)
);

