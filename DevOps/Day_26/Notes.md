Launch Template is only for the configuration not contains data if u want data create image
Is it possible to edit launch template? --> No
it is not possible to edit launch template You have to create new Version of launch template

we can change image size when we are creating image if required it customized we can add aditional volume
yes we can create isv volume by ourselves only at this point default size of isv is 80gb it will give by aws default 24 isv volume are free new volume you can always encrypted but root volume u cannot encrypt if u have to encrypt u have to create copy 
whenever u launch the ec2 encryption means encrypting volume not ec2 instance if  volume is encrypt then we say ec2 is encrypt 
images also not encrypted which image ur creating is also not encrypted because your original root volume are not encrypted 
new volume you can always encrypted
you can create isv volume in images ebs or isv u can create upto 0 to 23 is 24 in the images 
During the image creation process, Amazon EC2 creates a snapshot of each of the above volumes. snapshots not created for isv isv is temporary if you add new volume snapshot also create for that volume example 1 volume 1 snap shot 2 volume 2 
by default amis is private 
filter owened by me pvt img pub images disabled imgs
owend by me which i created 
privt means anyone shared the image to you that will under private pvt means only my 
public means overall images of every public images 
** encrypted snapshot cann not be shared 