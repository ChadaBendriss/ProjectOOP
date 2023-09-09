# ProjectOOP



In the future, intelligent vehicles will be equipped with various sensors, including LiDAR (Light Detection And Ranging), to autonomously navigate by capturing information about their surroundings. LiDAR uses laser beams to scan the scene in front, generating a 3D point cloud that represents the scene's structure.

An algorithm is needed to detect dominant planes within a cloud of 3D points. The dominant plane is the one containing the largest number of points within a certain distance (ε) from the plane. The RANSAC algorithm will be used for this purpose, which is an iterative method to identify geometric entities (or models) from data containing outliers.


Three point clouds (PointCloud1.xyz, PointCloud2.xyz, and PointCloud3.xyz) are given as input, and the task is to find the three most dominant planes for each of them. The output should include three xyz files for each point cloud, containing the points belonging to the dominant planes, and an additional xyz file with the original cloud minus the points belonging to the dominant planes. The output files are named by appending pX to the original point cloud filename, where X represents the plane number.

For example, the output files for PointCloud1 should be:
- PointCloud1_p1.xyz
- PointCloud1_p2.xyz
- PointCloud1_p3.xyz
- PointCloud1_p0.xyz (original cloud without the points of the dominant planes)


<img width="664" alt="image" src="https://github.com/ChadaBendriss/ProjetOOP/assets/113207156/4ff3b012-a2c6-41ba-be55-7156e9dd9a50">


<img width="662" alt="image" src="https://github.com/ChadaBendriss/ProjetOOP/assets/113207156/1e0d1c1f-bb74-487c-a858-58b25a5f42b1">


<img width="659" alt="image" src="https://github.com/ChadaBendriss/ProjetOOP/assets/113207156/339ce155-234d-4011-aacc-0bddfdfa7188">


<img width="656" alt="image" src="https://github.com/ChadaBendriss/ProjetOOP/assets/113207156/065a0f35-f68e-41d8-a295-d61caa4b0150">


