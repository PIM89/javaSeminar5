import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {
    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(findDuplicate(paths));
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder pathfile = new StringBuilder();
        for (String pStr : paths) {
            int i = 0;
            pathfile.setLength(0);
            while (pStr.charAt(i) != ' ') {
                i++;
            }
            pathfile.append(pStr.substring(0, i)).append('/');

            int pLen = ++i;
            int k = 0;

            for (int j = i; i < pStr.length(); i++) {
                if (pStr.charAt(i) == '(') {
                    pathfile.append(pStr.substring(j, i));
                    k = i + 1;
                } else if (pStr.charAt(i) == ')') {
                    String cont = pStr.substring(k, i);
                    if (!map.containsKey(cont)) {
                        map.put(cont, new ArrayList<>());
                    }
                    map.get(cont).add(pathfile.toString());
                    j = i + 2;
                    pathfile.setLength(pLen);
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> val : map.values()) {
            if (val.size() > 1) {
                ans.add(val);
            }
        }
        return ans;
    }
}
