/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        int n = employees.size();
        for(int i=0;i<n;i++){
            map.put(employees.get(i).id,employees.get(i));
        }
        return helperDFS(id,employees,map);
    }
    public int helperDFS(int id,List<Employee> employees,HashMap<Integer,Employee> map){
        int total = 0;
        for(int subId : map.get(id).subordinates){
            total += helperDFS(subId,employees,map);
        }
        return total + map.get(id).importance;
    }
}