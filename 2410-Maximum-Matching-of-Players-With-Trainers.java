class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n1 = players.length;
        int n2 = trainers.length;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int player = 0;
        int trainer = 0;
        while(trainer < n2 && player < n1){
            if(players[player] <= trainers[trainer]){
                player++;
            }
            trainer++;
        }
        return player;
    }
}