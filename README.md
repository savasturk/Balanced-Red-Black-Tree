# Balanced-Red-Black-Tree
Red Black Tree and balance

RULES

Input Type:
o V = Value of node. (Mehmet)
o K = Key of node. (29)
Balancing Conditions:
o If root is not BLACK.
o If two nodes in a row are RED.
o If the difference of depth between any two subtrees is more than 1.
Balancing Transactions:
o If root = RED then Recolor(root).
o If node.uncle = RED then Recolor(node.parent, node.grandparent, node.uncle).
o If node.uncle = BLACK and node_positions = TRIANGLE then
Rotate(node.parent). (Figure 1.A)
o If node.uncle = BLACK and node_positions = LINE then
Rotate(node.grandparent) and Recolor(node.parent, node.grandparent).
(Figure 1.B)
o If the height of the left and right subtrees of each node is more than 1 then
Rotate(node.grandgrandparent)
and
Recolor(node.grandparent,
node.grandgrandparent).
Usage of Abstract Data Types (ADT) is required.
Object Oriented Principles (OOP) and try-catch exception handling must be used when
it is needed.
After balancing process, difference between depth of the right and left tree at any part
of the tree should be 0 or 1.
