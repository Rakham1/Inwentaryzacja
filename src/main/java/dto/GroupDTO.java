package dto;

public class GroupDTO {
    private long groupId;
    private String groupName;
    private boolean isPermament;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isPermament() {
        return isPermament;
    }
}
