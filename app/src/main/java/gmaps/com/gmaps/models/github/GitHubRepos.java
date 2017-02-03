package gmaps.com.gmaps.models.github;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Durga Prasad on 18-01-2017.
 */


public class GitHubRepos {

    @SerializedName("id")
    public Integer id;
    @SerializedName("name")
    public String name;

    @SerializedName("full_name")
    public String fullName;

    @SerializedName("owner")

    public Owner owner;
    @SerializedName("private")

    public Boolean _privates;
    @SerializedName("html_url")

    public String htmlUrl;
    @SerializedName("description")

    public String description;
    @SerializedName("fork")

    public Boolean fork;
    @SerializedName("url")

    public String url;
    @SerializedName("forks_url")

    public String forksUrl;
    @SerializedName("keys_url")

    public String keysUrl;
    @SerializedName("collaborators_url")

    public String collaboratorsUrl;
    @SerializedName("teams_url")

    public String teamsUrl;
    @SerializedName("hooks_url")

    public String hooksUrl;
    @SerializedName("issue_events_url")

    public String issueEventsUrl;
    @SerializedName("events_url")

    public String eventsUrl;
    @SerializedName("assignees_url")

    public String assigneesUrl;
    @SerializedName("branches_url")

    public String branchesUrl;
    @SerializedName("tags_url")

    public String tagsUrl;
    @SerializedName("blobs_url")

    public String blobsUrl;
    @SerializedName("git_tags_url")

    public String gitTagsUrl;
    @SerializedName("git_refs_url")

    public String gitRefsUrl;
    @SerializedName("trees_url")

    public String treesUrl;
    @SerializedName("statuses_url")

    public String statusesUrl;
    @SerializedName("languages_url")

    public String languagesUrl;
    @SerializedName("stargazers_url")

    public String stargazersUrl;
    @SerializedName("contributors_url")

    public String contributorsUrl;
    @SerializedName("subscribers_url")

    public String subscribersUrl;
    @SerializedName("subscription_url")

    public String subscriptionUrl;
    @SerializedName("commits_url")

    public String commitsUrl;
    @SerializedName("git_commits_url")

    public String gitCommitsUrl;
    @SerializedName("comments_url")

    public String commentsUrl;
    @SerializedName("issue_comment_url")

    public String issueCommentUrl;
    @SerializedName("contents_url")

    public String contentsUrl;
    @SerializedName("compare_url")

    public String compareUrl;
    @SerializedName("merges_url")

    public String mergesUrl;
    @SerializedName("archive_url")

    public String archiveUrl;
    @SerializedName("downloads_url")

    public String downloadsUrl;
    @SerializedName("issues_url")

    public String issuesUrl;
    @SerializedName("pulls_url")

    public String pullsUrl;
    @SerializedName("milestones_url")

    public String milestonesUrl;
    @SerializedName("notifications_url")

    public String notificationsUrl;
    @SerializedName("labels_url")

    public String labelsUrl;
    @SerializedName("releases_url")

    public String releasesUrl;
    @SerializedName("deployments_url")

    public String deploymentsUrl;
    @SerializedName("created_at")

    public String createdAt;
    @SerializedName("updated_at")

    public String updatedAt;
    @SerializedName("pushed_at")

    public String pushedAt;
    @SerializedName("git_url")

    public String gitUrl;
    @SerializedName("ssh_url")

    public String sshUrl;
    @SerializedName("clone_url")

    public String cloneUrl;
    @SerializedName("svn_url")

    public String svnUrl;
    @SerializedName("homepage")

    public Object homepage;
    @SerializedName("size")

    public Integer size;
    @SerializedName("stargazers_count")

    public Integer stargazersCount;
    @SerializedName("watchers_count")

    public Integer watchersCount;
    @SerializedName("language")

    public Object language;
    @SerializedName("has_issues")

    public Boolean hasIssues;
    @SerializedName("has_downloads")

    public Boolean hasDownloads;
    @SerializedName("has_wiki")

    public Boolean hasWiki;
    @SerializedName("has_pages")

    public Boolean hasPages;
    @SerializedName("forks_count")

    public Integer forksCount;
    @SerializedName("mirror_url")

    public Object mirrorUrl;
    @SerializedName("open_issues_count")

    public Integer openIssuesCount;
    @SerializedName("forks")

    public Integer forks;
    @SerializedName("open_issues")

    public Integer openIssues;
    @SerializedName("watchers")

    public Integer watchers;
    @SerializedName("default_branch")

    public String defaultBranch;

    @Override
    public String toString() {
        return "GitHubRepos{" +
                "_privates=" + _privates +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", owner=" + owner +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", description='" + description + '\'' +
                ", fork=" + fork +
                ", url='" + url + '\'' +
                ", forksUrl='" + forksUrl + '\'' +
                ", keysUrl='" + keysUrl + '\'' +
                ", collaboratorsUrl='" + collaboratorsUrl + '\'' +
                ", teamsUrl='" + teamsUrl + '\'' +
                ", hooksUrl='" + hooksUrl + '\'' +
                ", issueEventsUrl='" + issueEventsUrl + '\'' +
                ", eventsUrl='" + eventsUrl + '\'' +
                ", assigneesUrl='" + assigneesUrl + '\'' +
                ", branchesUrl='" + branchesUrl + '\'' +
                ", tagsUrl='" + tagsUrl + '\'' +
                ", blobsUrl='" + blobsUrl + '\'' +
                ", gitTagsUrl='" + gitTagsUrl + '\'' +
                ", gitRefsUrl='" + gitRefsUrl + '\'' +
                ", treesUrl='" + treesUrl + '\'' +
                ", statusesUrl='" + statusesUrl + '\'' +
                ", languagesUrl='" + languagesUrl + '\'' +
                ", stargazersUrl='" + stargazersUrl + '\'' +
                ", contributorsUrl='" + contributorsUrl + '\'' +
                ", subscribersUrl='" + subscribersUrl + '\'' +
                ", subscriptionUrl='" + subscriptionUrl + '\'' +
                ", commitsUrl='" + commitsUrl + '\'' +
                ", gitCommitsUrl='" + gitCommitsUrl + '\'' +
                ", commentsUrl='" + commentsUrl + '\'' +
                ", issueCommentUrl='" + issueCommentUrl + '\'' +
                ", contentsUrl='" + contentsUrl + '\'' +
                ", compareUrl='" + compareUrl + '\'' +
                ", mergesUrl='" + mergesUrl + '\'' +
                ", archiveUrl='" + archiveUrl + '\'' +
                ", downloadsUrl='" + downloadsUrl + '\'' +
                ", issuesUrl='" + issuesUrl + '\'' +
                ", pullsUrl='" + pullsUrl + '\'' +
                ", milestonesUrl='" + milestonesUrl + '\'' +
                ", notificationsUrl='" + notificationsUrl + '\'' +
                ", labelsUrl='" + labelsUrl + '\'' +
                ", releasesUrl='" + releasesUrl + '\'' +
                ", deploymentsUrl='" + deploymentsUrl + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", pushedAt='" + pushedAt + '\'' +
                ", gitUrl='" + gitUrl + '\'' +
                ", sshUrl='" + sshUrl + '\'' +
                ", cloneUrl='" + cloneUrl + '\'' +
                ", svnUrl='" + svnUrl + '\'' +
                ", homepage=" + homepage +
                ", size=" + size +
                ", stargazersCount=" + stargazersCount +
                ", watchersCount=" + watchersCount +
                ", language=" + language +
                ", hasIssues=" + hasIssues +
                ", hasDownloads=" + hasDownloads +
                ", hasWiki=" + hasWiki +
                ", hasPages=" + hasPages +
                ", forksCount=" + forksCount +
                ", mirrorUrl=" + mirrorUrl +
                ", openIssuesCount=" + openIssuesCount +
                ", forks=" + forks +
                ", openIssues=" + openIssues +
                ", watchers=" + watchers +
                ", defaultBranch='" + defaultBranch + '\'' +
                '}';
    }
}