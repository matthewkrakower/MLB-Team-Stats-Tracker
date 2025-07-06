CREATE TABLE IF NOT EXISTS teams (
    id SERIAL PRIMARY KEY,
    team VARCHAR(255),
    wins INTEGER,
    losses INTEGER,
    win_percentage VARCHAR(255)
);