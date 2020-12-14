CREATE TABLE EventDescriptions(
  id UUID NOT NULL,
  contest_id BIGINT,
  user_id BIGINT,
  type TEXT NOT NULL,
  event_id UUID NOT NULL
);

CREATE TABLE TabEvents(
  id UUID NOT NULL,
  url TEXT NOT NULL,
  active BOOLEAN NOT NULL,
  incognito BOOLEAN NOT NULL
);

CREATE TABLE MouseEnterEvents(
  id UUID NOT NULL
);

CREATE TABLE MouseLeaveEvents(
  id UUID NOT NULL
);

CREATE TABLE ProblemChangedEvents(
  id UUID NOT NULL,
  prev_problem_title TEXT NOT NULL,
  prev_problem_url TEXT NOT NULL
);

CREATE TABLE ProblemSentEvent(
  id UUID NOT NULL,
  title TEXT NOT NULL
);
