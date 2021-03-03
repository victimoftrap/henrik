CREATE TABLE event_descriptions(
  id UUID PRIMARY KEY,
  contest_id BIGINT,
  user_id BIGINT,
  type TEXT NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE tab_events(
  id UUID NOT NULL,
  url TEXT NOT NULL,
  active BOOLEAN NOT NULL,
  incognito BOOLEAN NOT NULL,

  FOREIGN KEY (id) REFERENCES event_descriptions(id) ON DELETE CASCADE
);

CREATE TABLE mouse_enter_events(
  id UUID NOT NULL,

  FOREIGN KEY (id) REFERENCES event_descriptions(id) ON DELETE CASCADE
);

CREATE TABLE mouse_leave_events(
  id UUID NOT NULL,

  FOREIGN KEY (id) REFERENCES event_descriptions(id) ON DELETE CASCADE
);

CREATE TABLE problem_changed_events(
  id UUID NOT NULL,
  prev_title TEXT NOT NULL,
  prev_url TEXT NOT NULL,

  FOREIGN KEY (id) REFERENCES event_descriptions(id) ON DELETE CASCADE
);

CREATE TABLE problem_sent_events(
  id UUID NOT NULL,
  title TEXT NOT NULL,

  FOREIGN KEY (id) REFERENCES event_descriptions(id) ON DELETE CASCADE
);
