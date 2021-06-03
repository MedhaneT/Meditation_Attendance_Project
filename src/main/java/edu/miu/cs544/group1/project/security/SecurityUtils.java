package edu.miu.cs544.group1.project.security;

import edu.miu.cs544.group1.project.config.JPAUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityUtils {
    public static JPAUserDetails getUserDetail() {
        return (JPAUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
