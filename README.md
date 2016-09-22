# How to run InfluxDB

1. Install `InfluxDB` via `Homebrew` package manager on your mac.
   ```bash
   brew update
   brew install influxdb
   ```      
2. Run db as a daemon via `influxd`.
    
3. Open `influx` shell in terminal.

4. Create database.
   ```bash
   CREATE DATABASE serviceHealthReports
   ```

5. Select db.
   ```bash
   USE serviceHealthReports
   ```
   
6. Insert data.
   ```bash
   INSERT cpu,host=serverA,region=us_west value=0.64
   INSERT cpu,host=serverA,region=us_west value=0.21
   ```

7. Try to get data.
   ```bash
   SELECT * FROM cpu
   ```
 