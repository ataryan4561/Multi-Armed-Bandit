import random
import math
def mab():
    arms = int(input("arms"))
    days = int(input("days"))   
    data = [[0]*days]*arms
    for i in range(arms):
        for j in range(days):
            data[i][j]=random.random()
    rew =[0]*arms
    pulls = [0]*arms
    ucb = [0]*arms
    for i in range(days):
        if (i<arms):
            rew[i]+=data[i][i]
            pulls[i]+=1
        else:
            maxi = 0
            ind =0
            for j in range(arms):
                ucb[j]=(rew[j]/pulls[j])+math.sqrt(2*math.log(i)/pulls[j])
                if (ucb[j]>maxi):
                    maxi = ucb[j]
                    ind = j
            rew[ind]+=data[ind][i]
            pulls[ind]+=1
    for i in range(arms):
        print(rew[i])
        print(pulls[i])
        print("\n")
        
mab()