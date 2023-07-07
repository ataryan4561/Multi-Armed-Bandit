module test;
parameter N = 25;
parameter T = 10000;
real data[N-1:0][T-1:0];
real rew[N-1:0];
reg integer pull[N-1:0];
integer i;
real df=0;
integer index=0;
real ucb;
integer j;
initial begin
for(i=0; i<N; i=i+1)
begin
    for(j=0; j<T; j=j+1)
    begin
        data[i][j]=$random%10;
        if(data[i][j]<0)
        begin
            data[i][j]=data[i][j]*(-1);
        end
    end
end
for(i=0; i<N; i++)
begin
    rew[i]=0;
    pull[i]=0;
end
for(i=0; i<T; i=i+1)
begin
    if(i<N)
    begin
        rew[i]=rew[i]+data[i][i];
        pull[i]=pull[i]+1;
    end
    else
    begin
        for(j=0; j<N; j=j+1)
        begin
            ucb = (rew[j]/pull[j]) +$sqrt(2*$ln(i)/pull[j]);
            if(ucb >df)
            begin
                df = ucb;
                index = j;
            end
        end
        rew[index]=rew[index]+data[index][i];
        pull[index]=pull[index]+1;
    end
end
for(i=0; i<N; i=i+1)
begin
    $display("%f %d %d",rew[i],pull[i],i);
end
end
endmodule