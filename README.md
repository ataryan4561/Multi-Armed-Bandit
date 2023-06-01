# Multi-Armed-Bandit
Multi-Armed bandit is a classical framework problem in the field of reinforcement learning. It involves an agent that faces a set of instructions, and these are often referred to as the arms. Each arm has an unknown probability distribution associated with it. The agent’s cumulative goal is to maximize the reward over a series of interactions. 

The term bandit is included in this because it is like a gambler facing a set of machines and trying to figure out which machines play the most to increase their reward as high as possible.

The agent has only basic or significantly little knowledge about the machines. So, to have a balance, there should be good knowledge of exploration (trying out different arms to learn their properties) and exploitation (leveraging the information gained so far to choose the most promising arm). The challenge always lies in finding a suitable trade-off between exploration and exploitation to maximize the reward for longer times.

There are many algorithms for the multi-armed bandit.
1)	– Epsilon Greedy: - This algorithm selects the arm with the highest estimated reward most of the time (exploitation) but occasionally explores other arms with a small probability (exploration).
2)	– Upper Confidence Bound (UCB): UCB algorithms calculate the upper confidence bound for each arm based on the observed rewards and uncertainties. It balances exploration and exploitation by selecting the arm with the highest upper confidence bound.
3)  – Thompson Sampling: Thompson Sampling employs a Bayesian approach. It maintains a posterior distribution over each arm's reward distribution parameters. At each step, it samples a set of parameters from the posterior and selects the arm with the highest sample (exploitation), updating the posterior based on the observed reward.
