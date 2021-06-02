package com.github.victimoftrap.henrik.model.events;

import com.github.victimoftrap.henrik.model.EventDescription;
import com.github.victimoftrap.henrik.model.EventType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "solution_code_sent_events")
public class SolutionCodeSentEvent extends EventDescription {
    @Column(name = "problem_id")
    private String problemId;

    @Column(name = "problem_title")
    private String problemTitle;

    @Column(name = "problem_url")
    private String problemUrl;

    @Column(name = "compiler")
    private String compiler;

    @Column(name = "solution_type")
    private String solutionType;

    @Column(name = "source")
    private String source;

    public SolutionCodeSentEvent() {
    }

    public SolutionCodeSentEvent(final UUID id,
                                 final long contestId,
                                 final long userId,
                                 final String userLogin,
                                 final ZonedDateTime createdAt,
                                 final EventType type,
                                 final String problemId,
                                 final String problemTitle,
                                 final String problemUrl,
                                 final String compiler,
                                 final String solutionType,
                                 final String source) {
        super(id, contestId, userId, userLogin, createdAt, type);
        this.problemId = problemId;
        this.problemTitle = problemTitle;
        this.problemUrl = problemUrl;
        this.compiler = compiler;
        this.solutionType = solutionType;
        this.source = source;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(final String problemId) {
        this.problemId = problemId;
    }

    public String getProblemTitle() {
        return problemTitle;
    }

    public void setProblemTitle(final String problemTitle) {
        this.problemTitle = problemTitle;
    }

    public String getProblemUrl() {
        return problemUrl;
    }

    public void setProblemUrl(final String problemUrl) {
        this.problemUrl = problemUrl;
    }

    public String getCompiler() {
        return compiler;
    }

    public void setCompiler(final String compiler) {
        this.compiler = compiler;
    }

    public String getSolutionType() {
        return solutionType;
    }

    public void setSolutionType(final String solutionType) {
        this.solutionType = solutionType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(final String source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SolutionCodeSentEvent that = (SolutionCodeSentEvent) o;
        return Objects.equals(problemId, that.problemId)
                && Objects.equals(problemTitle, that.problemTitle)
                && Objects.equals(problemUrl, that.problemUrl)
                && Objects.equals(compiler, that.compiler)
                && Objects.equals(solutionType, that.solutionType)
                && Objects.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), problemId, problemTitle, problemUrl, compiler, solutionType, source);
    }

    @Override
    public String toString() {
        return "SolutionCodeSentEvent{" +
                "problemId='" + problemId + '\'' +
                ", problemTitle='" + problemTitle + '\'' +
                ", problemUrl='" + problemUrl + '\'' +
                ", compiler='" + compiler + '\'' +
                ", solutionType='" + solutionType + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
