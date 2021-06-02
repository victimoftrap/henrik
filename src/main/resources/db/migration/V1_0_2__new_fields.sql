ALTER TABLE event_descriptions ADD COLUMN user_login TEXT NOT NULL;

ALTER TABLE problem_changed_events ADD COLUMN prev_id TEXT NOT NULL;

ALTER TABLE problem_sent_events ADD COLUMN problem_id TEXT NOT NULL;
ALTER TABLE problem_sent_events ADD COLUMN problem_url TEXT NOT NULL;
ALTER TABLE problem_sent_events RENAME COLUMN title TO problem_title;

ALTER TABLE solution_code_sent_events ADD COLUMN problem_id TEXT NOT NULL;
