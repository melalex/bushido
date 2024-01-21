# Auto parts compatibility

SaldoApps R&D department wants to see if users can order and assemble automobiles that they can control using our
platform. The first step is to set up a catalog of the automobile parts and a compatibility mapping. Each automobile
part has a name, serial number, manufacturer, weight, and a list of other parts it is compatible with within the system.
How would you model a data storage of the compatibility of parts? Please write a small document or sketch explaining
your idea. - How is your solution impacted if the number of parts in the catalog reaches tens of millions? - How does
the solution change if new parts are added and old parts removed from the catalog at high frequency? Be prepared to
discuss your solution.

## Approach 1: Store entities in RDBMS

```
       ┌─────────────────────────┐
       │auto_parts_to_auto_parts │
       ├─────────────────────────┤
┌──────┤first_id: INT            │
│      │second_id: INT           ├───────┐
│      └─────────────────────────┘       │
│                                        │
│                                        │
│                                        │
│      ┌─────────────────────────┐       │
└─────►│auto_parts               │◄──────┘
       ├─────────────────────────┤
       │id: INT                  │
       │name: VARCHAR(100)       │
       │serial_number: BINARY(16)│        ┌──────────────────┐
       │manufactorer_id: INT     ├───────►│manufactorer      │
       │weight: INT              │        ├──────────────────┤
       └─────────────────────────┘        │id: INT           │
                                          │name: VARCHAR(100)│
                                          └──────────────────┘
```

Naive solution using RDMS. Auto part entity stored in a `auto_parts` table. Parts compatibility stored in
a `auto_parts_to_auto_parts` table. To omit duplicate relations, backend must enforce `first_id < second_id`. Assuming
that number of manufactures is limited and serial_number is a UUID, size of a single auto part entity would be 228
bytes. So to store 10 million of records we would require 2.28 Tb of storage space (not taking space required by indices
and relationship table).

Pros:

- Simple to implement, most developers are familiar with RDBMS
- ACID transactions

Cons:

- Because RDBMS is unable to scale horizontally, we would require at least 3 Tb of disk storage on a single machine
- `first_id < second_id` rule enforcement would require additional effort from backend side
- Joins, that are required to select auto part, would slow down queries

## Approach 2: Store entities in NoSQL DB (document oriented, column oriented etc.)

```
┌─────────────────────────┐
│Compatibility            │
├─────────────────────────┤
│first: ID                │
│second: ID               │
└─────────────────────────┘

┌─────────────────────────┐
│AutoPart                 │
├─────────────────────────┤
│id: ID                   │
│name: String             │
│serialNumber: String     │
│manufactorer: String     │
│weight: int              │
└─────────────────────────┘
```

Data model similar to previous one, but it was denormalized.

Pros:

- Horizontal scaling
- Fast selects when working with a single table

Cons:

- `first_id < second_id` rule enforcement would require additional effort from backend side
- Requires several separate queries to select `AutoPart` and its compatible parts
- Requires more space to store same amount of data

## Approach 3: Store entities in Graph DB

```
┌───────────────────────────────┐
│AutoPart                       │
├───────────────────────────────┤
│id: ID                         │
│name: String                   │
│serialNumber: String           │
│manufactorer: String           │
│weight: int                    │
│compatibleParts: List<AutoPart>│
└───────────────────────────────┘
```

Since auto parts and their compatibility mapping could be represented as a graph, graph oriented database could be used.
In this data model `AutoPart` entity would be stored in graph nodes and compatibility mapping in vertices.

Pros:

- Fast reads and wrights since data is graph oriented by nature.
- Optimal storage of compatibilities

Cons:

- Horizontal scaling
- It's not as mature technology as others
- Not many developers have experiences with this
- Using Graph DB for such simple case could be overkill
