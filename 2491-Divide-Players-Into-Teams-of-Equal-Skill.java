class Solution {
    public long dividePlayers(int[] skill) {
        int sum = 0;
        long ans = 0;
        int n = skill.length;
        int noOfTeams = n/2;
        Arrays.sort(skill);
        for(int i=0;i<n;i++){
            sum += skill[i];
        }
        if(sum % noOfTeams != 0)
            return -1;
        int singleTeamPower = sum / noOfTeams;
        int a = 0;
        int b = n -1;
        while(a < b){
            if((skill[a] + skill[b]) != singleTeamPower)
                return -1;
            ans += (skill[a] * skill[b]);
            a++;
            b--;
        }
        return ans;
    }
}