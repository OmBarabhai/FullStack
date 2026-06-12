Launch once like this works only while ec2 is running state it will save your time for quickly want to create ec2 instance 

while detachign root volume your ec2 must be stopped for detach purpose of root volume when the vol is in attach state it will show inuse and while detach state it will shows available


while attaching volume they must have to be same availabilty zone they not show you other availability zone instance which you created because that is in other availabilty zone

and while attaching root volume it must be /dev/sda1 because it is root volume not other
u can attach root volume while ec2 is stoped 
attach detach possible to different ec2 instance but they should must be in same availabilty zone


** remember whenever your creating volume u should be in same availability zone of ec2 instance u have to check your ec2 instance availability zone and new volume availabilty zone are same or not if you create d image frome  ec2 instance and pasword dshould be same for both image ec2 and original ec2 
