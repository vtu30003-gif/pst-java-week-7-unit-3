class UndergroundSystem {
    
    // Helper class to store check-in details
    private static class CheckInRecord {
        String stationName;
        int time;
        
        CheckInRecord(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
    
    // Helper class to store aggregated journey statistics
    private static class JourneyStats {
        double totalTime = 0;
        int totalTrips = 0;
        
        void addTrip(int travelTime) {
            this.totalTime += travelTime;
            this.totalTrips++;
        }
        
        double getAverage() {
            return totalTime / totalTrips;
        }
    }
    
    private Map<Integer, CheckInRecord> checkIns;
    private Map<String, JourneyStats> journeyData;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        journeyData = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInRecord(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInRecord record = checkIns.remove(id);
        String startStation = record.stationName;
        int travelTime = t - record.time;
        
        String routeKey = startStation + "->" + stationName;
        journeyData.putIfAbsent(routeKey, new JourneyStats());
        journeyData.get(routeKey).addTrip(travelTime);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        return journeyData.get(routeKey).getAverage();
    }
}