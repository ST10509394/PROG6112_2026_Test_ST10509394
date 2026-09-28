package com.mycompany.yearlysales;

public class SalesProcessor 
{
    // 1D Array for citties
    private final String[] cities =
    {
        "Cape Town",
        "Port Elizabeth",
        "Pretoria"
    };
    
    // 1D Array for console names
    private final String[] consoles =
    {
        "PS5",
        "XBOX",
        "SWITCH"
    };
    
    // 2D Array for Sales Data 
    private final int[][] salesData = 
    {
        {1000, 2000, 3000},
        {2000, 3000, 4000},
        {1500, 1100, 1200}
    };
    
    // Calculates the total sales of all consoles for a specific city
    public int calculateCityTotal(int cityIndex)
    {
        int total = 0;
        for (int col = 0; col < salesData[cityIndex].length; col++)
        {
            total += salesData[cityIndex][col];
        }
        return total;
    }
    
    // Finding the name of the city with the highest total sales across all consoles
    public String getTopSellingCity()
    {
        int maxSales = -1;
        String topCity = "";
        
        for (int i = 0; i < cities.length; i++)
        {
            int currentCityTotal = calculateCityTotal(i);
            if (currentCityTotal > maxSales)
            {
                maxSales = currentCityTotal;
                topCity = cities[i];
            }
        }
        return topCity;
    }
    
    // Printed report accoridng to ouput format
    public void printReport()
    {
        String border = "------------------------------------------------------";
        
        System.out.println("GAMING CONSOLE REPORT");
        System.out.println(border); 
        
        // Header row for consoles
        System.out.printf("%-18s", "");
        for (String consoles : consoles)
        {
            System.out.printf("%-12s", consoles);
        }
        System.out.println();
        
        for (int i = 0; i < cities.length; i++)
        {
            System.out.printf("%-12d", cities[i]);
            for (int j = 0; j < salesData[i].length; j++)
            {
                System.out.printf("%-12d", salesData[i][j]);
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println("CONSOLE SALES TOTALS FOR EACH CITY");
        System.out.println(border);
        
        // Print city totals
        for (int i = 0; i < cities.length; i++)
        {
            System.out.printf("%-18s%-12d%n", cities[i], calculateCityTotal(i));
        }
        
        System.out.println();
        System.out.println("CITY WITH THE MOST SALES: " + getTopSellingCity());
        System.out.println(border);
    }
}
