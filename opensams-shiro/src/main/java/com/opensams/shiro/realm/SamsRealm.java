package com.opensams.shiro.realm;

import com.opensams.dal.pojo.Permission;
import com.opensams.dal.pojo.Role;
import com.opensams.dal.pojo.Student;
import com.opensams.service.AuthenticationService;
import com.opensams.service.AuthorizationService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Kevin Leung
 */
public class SamsRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(SamsRealm.class);

    @Resource
    private AuthorizationService authorizationService;

    @Resource
    private AuthenticationService authenticationService;

    public SamsRealm() {
        super.setName("samsRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String loginName = (String) principals.getPrimaryPrincipal();

        List<Role> roles = authorizationService.getRolesByStudentCode(loginName);

        Set<String> roleCodes = roles.stream()
                .map(Role::getRoleCode)
                .collect(Collectors.toSet());

        if (CollectionUtils.isEmpty(roles)) {
            LOGGER.debug("Do get authorization info fail in getting user roles.");
        }

        List<Permission> permissions = authorizationService.getPermissionsByRoleCodes(
                new ArrayList<>(roleCodes));

        if (CollectionUtils.isEmpty(permissions)) {
            LOGGER.debug("Do get authorization info fail in getting user permissions.");
        }

        Set<String> permissionCodes = permissions.stream()
                .map(Permission::getPermissionCode)
                .collect(Collectors.toSet());

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleCodes);
        authorizationInfo.setStringPermissions(permissionCodes);

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String loginName = (String) token.getPrincipal();

        Student student = authenticationService.getStudentByCode(loginName);

        if (student == null) {
            return null;
        }

        return new SimpleAuthenticationInfo(
                student.getLoginName(), student.getLoginPwd(), "SamsRealm");
    }
}
