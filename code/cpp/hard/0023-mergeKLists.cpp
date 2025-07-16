class compare {
    public:
     bool operator()(ListNode* a, ListNode* b) { return a->val > b->val; }
 };
 
 class Solution {
    public:
     ListNode* mergeKLists(vector<ListNode*>& lists) {
         priority_queue<ListNode*, vector<ListNode*>, compare> pq;
         
        for (ListNode* list : lists) {
             if (list != nullptr) {
                 pq.push(list);
             }
         }
         
         ListNode* dummy = new ListNode(-1);
         ListNode* tail = dummy;
         
         while (!pq.empty()) {
             ListNode* curr = pq.top();
             pq.pop();
             
             tail->next = curr;
             tail = tail->next;
             
             if (curr->next != nullptr) {
                 pq.push(curr->next);
             }
         }
         
         ListNode* head = dummy->next;
         delete dummy;
         return head;
     }
 };