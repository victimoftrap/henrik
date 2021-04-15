CREATE TABLE solution_code_sent_events(
  id UUID NOT NULL,
  problem_title TEXT NOT NULL,
  problem_url TEXT NOT NULL,
  compiler TEXT NOT NULL,
  solution_type TEXT NOT NULL,
  source TEXT NOT NULL,

  FOREIGN KEY (id) REFERENCES event_descriptions(id) ON DELETE CASCADE
);
