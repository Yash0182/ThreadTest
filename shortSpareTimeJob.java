import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class shortSpareTimeJob {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of testcases:");
		int t=Integer.parseInt(br.readLine());
		
		while(t-->0)
		{
			//Number of processes
			System.out.println("Enter the number of processes:");
			int n = Integer.parseInt(br.readLine());
			
			//Arrival, Burst, waiting and Remaining time array initialization
			long at[] = new long[n];
			long bt[] = new long[n];
			long wt[] = new long[n];
			long rt[] = new long[n];
			double avgBurstTime = 0;
			long minBurstTime = Long.MAX_VALUE;
			long minArrivalTime = Long.MAX_VALUE;
			double sum =0;
			
			//Input Data
			StringTokenizer st;
			for(int i=0;i<n;i++)
			{
				System.out.println("Enter the Arrival Time and Burst Time of Process "+(i+1)+":");
				st = new StringTokenizer(br.readLine());
				at[i] = Long.parseLong(st.nextToken());
				bt[i] = Long.parseLong(st.nextToken());
				//rt[i] = bt[i];
				sum += bt[i];
				
				//Finding Minimum Burst Time
				if(minBurstTime > bt[i])
				{
					minBurstTime = bt[i];
				}
				
				//Finding Minimum Arrival Time
				if(minArrivalTime > at[i])
				{
					minArrivalTime = at[i];
				}
			}
			
			for(int i=0;i<at.length;i++)
			{
				for(int j=1;j<at.length-i;j++)
				{
					if(at[j-1]>at[j])
					{
						long temp = at[j-1];
						at[j-1] = at[j];
						at[j] = temp;
						
						temp = bt[j-1];
						bt[j-1] = bt[j];
						bt[j] = temp;
						
					}
				}
			}
			
			for(int i=0;i<bt.length;i++)
			{
				//Initializing remaining time array
				rt[i] = bt[i];
			}
			
			//Average burst time
			avgBurstTime += Math.ceil(sum/n);
			System.out.println("Average Burst Time: "+avgBurstTime);
			
			//Initializing time quantum
			long quantumTime = 0;
			System.out.println("Minimum Burst Time: "+minBurstTime);
			if(minBurstTime < (avgBurstTime/2))
			{
				//Average Burst Time – Smallest Burst Time
				quantumTime = (long)avgBurstTime - minBurstTime;
			}
			else
			{
				//(Average Burst Time – ((Average Burst Time/2)-1))
				quantumTime = (long)avgBurstTime - (((long)(avgBurstTime/2))-1);
			}
			
			System.out.println("Quantum Time:"+quantumTime);
			
			int remain = n;
			int flag=0;
			double waitingSum = 0;
			long time=minArrivalTime;
			
			for(int i=0; remain>0;)
			{
				//process burst time is less then quantum time
				if(rt[i]<=quantumTime && rt[i]>0)
				{
					time+=rt[i];
					rt[i]=0;
					flag=1;
				}
				else
				{
					//Remaining time is greater then quantum time
					if(rt[i]>0)
					{
						time+=quantumTime;
						rt[i]-=quantumTime;
						
						//SSTJC Algo
						if(rt[i]<=(quantumTime/2))
						{
							time+=rt[i];
							rt[i]=0;
							flag=1;
						}
					}
				}
				
				//Checking if process is completed or not
				if(rt[i]==0 && flag==1)
				{
					remain--;
					wt[i] += (time - at[i] - bt[i]);
					flag=0;
				}
					
				//if it is last process and all process are not completed start all over again
				if(i==n-1)
				{
					i=0;
				}
				else
				{
					//if next has arrived
					if(at[i+1]<=time)
					{
						i++;
					}
					else
					{
						i=0;
					}
				}
			}//end for
			
			for(int i=0;i<wt.length;i++)
			{
				System.out.println("Waiting time for Process "+(i+1)+": "+wt[i]);
				waitingSum += wt[i];
			}
			
			System.out.println("Average Waiting Time: "+waitingSum/n);
		}//end while
	}
}



