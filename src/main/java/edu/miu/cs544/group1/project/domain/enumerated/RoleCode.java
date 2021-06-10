package edu.miu.cs544.group1.project.domain.enumerated;

public enum RoleCode {
    ADMIN, FACULTY, STUDENT;

    public String toAuthority() {
        return "ROLE_" + name();
    }
}
