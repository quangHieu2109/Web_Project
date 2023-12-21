package security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {
//	public static final String USER="user";
	public static final String ADMIN="admin";
	public static final String JOURNALIST="journalist";
	private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();
	static{
		List<String> urlJournalist = new ArrayList<String>();
		urlJournalist.add("/pageJournalist");
		urlJournalist.add("/ShowListServlet");
		
		List<String> urlAdmin = new ArrayList<String>();
		mapConfig.put(JOURNALIST, urlJournalist);
		
	}
	public static Set<String> getAllAppRoles() {
		return mapConfig.keySet();
	}

	public static List<String> getUrlPatternsForRole(String role) {
		return mapConfig.get(role);
	}

}
