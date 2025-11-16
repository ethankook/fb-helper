CREATE TABLE oauth_token
(
    id            BIGSERIAL PRIMARY KEY,
    provider      TEXT        NOT NULL,
    access_token  TEXT        NOT NULL,
    refresh_token TEXT        NOT NULL,
    expires_at    TIMESTAMPTZ NOT NULL,
    scope         TEXT,
    token_type    TEXT,
    raw_response  JSONB,
    CONSTRAINT uq_oauth_provider UNIQUE (provider),

    createdAt     TIMESTAMPTZ NOT NULL DEFAULT now(),
    updatedAt     TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE TABLE league
(
    id               BIGSERIAL PRIMARY KEY,
    yahoo_league_key TEXT        NOT NULL UNIQUE,
    scoring_type     TEXT        NOT NULL,
    name             TEXT        NOT NULL,
    season_year      INTEGER     NOT NULL,
    num_teams        INTEGER     NOT NULL,

    createdAt        TIMESTAMPTZ NOT NULL DEFAULT now(),
    updatedAt        TIMESTAMPTZ NOT NULL DEFAULT now()

);

CREATE TABLE team
(
    id              BIGSERIAL PRIMARY KEY,
    league_id       BIGINT      NOT NULL REFERENCES league (id) ON DELETE CASCADE,
    name            TEXT        NOT NULL,
    user_team       BOOLEAN     NOT NULL,
    yahoo_team_key  TEXT        NOT NULL,

    -- H2H CATEGORIES --
    punt_categories TEXT,
    win_categories  TEXT,

    createdAt       TIMESTAMPTZ NOT NULL DEFAULT now(),
    updatedAt       TIMESTAMPTZ NOT NULL DEFAULT now(),

    CONSTRAINT uq_team UNIQUE (league_id, yahoo_team_key)
);

CREATE TABLE player
(
    id              BIGSERIAL PRIMARY KEY,
    yahoo_player_id TEXT        NOT NULL UNIQUE,

    full_name       TEXT        NOT NULL,
    first_name      TEXT,
    last_name       TEXT,

    nba_team        VARCHAR(3),
    positions       TEXT,
    status          TEXT,

    createdAt       TIMESTAMPTZ NOT NULL DEFAULT now(),
    updatedAt       TIMESTAMPTZ NOT NULL DEFAULT now()

);

CREATE TABLE stat_line
(
    id        BIGSERIAL PRIMARY KEY,
    player_id BIGINT      NOT NULL REFERENCES player (id) ON DELETE CASCADE,
    game_date DATE        NOT NULL,

    -- stats --
    pts       NUMERIC(5, 2),
    reb       NUMERIC(5, 2),
    ast       NUMERIC(5, 2),
    stl       NUMERIC(5, 2),
    blk       NUMERIC(5, 2),
    threes    NUMERIC(5, 2),
    tov       NUMERIC(5, 2),

    fgm       NUMERIC(5, 2),
    fga       NUMERIC(5, 2),
    ftm       NUMERIC(5, 2),
    fta       NUMERIC(5, 2),
    minutes   NUMERIC(5, 2),

    raw_json  JSONB,

    createdAt TIMESTAMPTZ NOT NULL DEFAULT now(),

    CONSTRAINT uq_stat_line UNIQUE (player_id, game_date)

);

CREATE TABLE ownership
(
    id              BIGSERIAL PRIMARY KEY,
    player_id       BIGINT        NOT NULL REFERENCES player (id) ON DELETE CASCADE,

    snapshot_date   DATE          NOT NULL,
    percent_owned   NUMERIC(5, 2) NOT NULL,
    percent_started NUMERIC(5, 2),

    raw_json        JSONB,

    createdAt       TIMESTAMPTZ   NOT NULL DEFAULT now(),
    updatedAt       TIMESTAMPTZ   NOT NULL DEFAULT now(),

    CONSTRAINT uq_ownership UNIQUE (player_id, snapshot_date)
);

CREATE TABLE sync_state
(
    id                    BIGSERIAL PRIMARY KEY,
    last_synced_stats     DATE,
    last_synced_ownership DATE,

    createdAt             TIMESTAMPTZ NOT NULL DEFAULT now(),
    updatedAt             TIMESTAMPTZ NOT NULL DEFAULT now()
);