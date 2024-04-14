public class FamilyTree {
    FamilyTreeNode ancestor;

    public FamilyTree(String ancestorName) {
        this.ancestor = new FamilyTreeNode(ancestorName);
    }

    public void addChild(String childName) {
        if (this.ancestor.firstChild == null) {
            this.ancestor.firstChild = new FamilyTreeNode(childName);
        } else {
            FamilyTreeNode current = this.ancestor.firstChild;
            while (current.nextSibling != null) {
                current = current.nextSibling;
            }
            current.nextSibling = new FamilyTreeNode(childName);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(printFamilyMember(this.ancestor, ""));
        return builder.toString();
    }

    private String printFamilyMember(FamilyTreeNode node, String prefix) {
        StringBuilder builder = new StringBuilder(prefix + node.name + "\n");
        if (node.firstChild != null) {
            builder.append(printFamilyMember(node.firstChild, prefix + "    "));
        }
        if (node.nextSibling != null) {
            builder.append(printFamilyMember(node.nextSibling, prefix));
        }
        return builder.toString();
    }
}
