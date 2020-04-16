#include <stdio.h>
#include <stdlib.h>

struct Node {
    char person;
    int jobNo;
    int cost;
    struct Node* parent;
};

int inArray(int el, int trackJob[50], int *tjCount){
        //returns 1 if el is in the array trackJob
        int i=0;
        for(i=0; i<*tjCount; i++){
                if(el==trackJob[i]){
                        return 1;
                }

        }
        return 0;
}

int findLeast(int costMatrix[4][4], int i, int trackJob[50], int *tjCount){
        //finds the least cost job in a particular row 'i', also making sure
        //that the least cost job is not part of trackJob array
        int j=0, least=9999;
        for(j=0; j<4; j++){
                if(costMatrix[i][j]<least && inArray(j, trackJob, tjCount)==0)
                {
                        least=costMatrix[i][j];
                        trackJob[*tjCount]=j;
                }

        }
        *tjCount+=1;
        return least;
}

int returnCost(int costMatrix[4][4], int i, int j){
        int sum=costMatrix[i][j];
        int k;
        int trackJob[50] = {-1};
        int tj=0;
        int *tjCount = &tj;
        trackJob[tj++]=j;
        for(k=0; k<4; k++){
                if(k==i)
                        continue;
                sum+=findLeast(costMatrix, k, trackJob, tjCount);

        }
        return sum;
}

int jobTaken(struct Node* n, int jobNo){
        //returns 0 if job hasn't been taken
        //returns 1 if job has been taken
        if(n==NULL){
                return 0;
        }

        if(n->jobNo == jobNo)
        {
                return 1;
        }
        else{
                return jobTaken(n->parent, jobNo);
        }

}

int main()
{
        int costMatrix[4][4]={
                {9, 2, 7, 8},
                {6, 4, 3, 7},
                {5, 8, 1, 8},
                {7, 6, 9, 4}
        };
        int n = 4;
        struct Node* head = NULL;
        struct Node* lowestCost = NULL;
        struct Node* ptr = NULL;
        ptr = (struct Node*)malloc(sizeof(struct Node));
        ptr->parent = head;
        lowestCost = (struct Node*)malloc(sizeof(struct Node));
        lowestCost->cost=9999;
        ptr->jobNo=-9999;
        int i, j;
        for(i=0; i<n; i++){
                ptr->person = i+65;
                for(j=0; j<n; j++){
                        if(jobTaken(ptr, j))
                                continue;
                        ptr->cost = returnCost(costMatrix, i, j);
                        if(ptr->cost<lowestCost->cost){
                                free(lowestCost);
                                lowestCost=ptr;
                                ptr = (struct Node*)malloc(sizeof(struct Node));
                                ptr->parent=head;
                                lowestCost->person=i+65;
                                lowestCost->jobNo=j;
                        }
                }
                lowestCost->parent = head;
                head = lowestCost;
                free(ptr);
                ptr = (struct Node*)malloc(sizeof(struct Node));
                ptr->parent=head;
                lowestCost=(struct Node*)malloc(sizeof(struct Node));
                lowestCost->cost=9999;
                ptr->jobNo=-9999;
        }
        free(ptr);
        printf("\nThe optimal selection is: ");
        while(head!=NULL){
                printf("\nPerson: %c, Job: %d ", head->person, head->jobNo);
                head=head->parent;
        }
        return 0;
}
