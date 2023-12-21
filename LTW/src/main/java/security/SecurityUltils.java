package security;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import model.NguoiDung;

public class SecurityUltils {
	public static boolean isSecurityPage(HttpServletRequest request,String path) {
		Set<String> roles = SecurityConfig.getAllAppRoles();

		for (String role : roles) {
			List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
			if(urlPatterns!=null) {
			for (String string : urlPatterns) {
				if (path.contains(string)) {
					
					return true;
				}
			}
			}
		}
		return false;
	}

	public static boolean hasPermission(HttpServletRequest req, NguoiDung user) {

		String urlPattern = UrlPatternUtils.getUrlPattern(req);

		for (String role : user.getRoles()) {

			List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
			if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
				return true;
			}
		}
		return false;
	}
}
