package library.management.entities;

public class Member {

    private String memberId;
    private String memberName;
    private String memberEmail;
    private String memberPhone;
    private String memberMembershipDate;

    public Member() {
    }

    public Member(String memberId, String memberName, String memberEmail,
                  String memberPhone, String memberMembershipDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
        this.memberMembershipDate = memberMembershipDate;
    }

    public String getMemberInfo() {
        return String.format(
                "Member ID: %s with name %s, email %s, phone %s joined on %s",
                memberId, memberName, memberEmail, memberPhone, memberMembershipDate
        );
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberMembershipDate() {
        return memberMembershipDate;
    }

    public void setMemberMembershipDate(String memberMembershipDate) {
        this.memberMembershipDate = memberMembershipDate;
    }
}