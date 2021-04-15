Welcome to use the vision-wallet-client.  
## Get started
### Download vision-wallet-client

    git clone https://github.com/vision-consensus/vision-wallet-client.git

### Edit config.conf in src/main/resources

```
net {
  type = mainnet
  # type = testnet
}

fullnode = {
  ip.list = [
    "fullnode ip : port"
  ]
}

soliditynode = {
  ip.list = [
    "solidity ip : port"
  ]
} // NOTE: solidity node is optional

blockNumberStartToScan = 22690588 // NOTE: this field is optional
```

### Run a web wallet

- connect to fullNode and solidityNode


    NOTE: These nodes would consume a lot of memory and CPU. Please be aware if you do not use wallet, just kill them.
- compile and run web wallet

    ```console
    $ cd vision-wallet-client
    $ ./gradlew build
    $ cd build/libs
    $ java -jar vision-wallet-client.jar
    ```
### Run wallet by the specified configuration file:  -c as config-dev.conf ; the default is config.conf
                                                                               
- compile and run web wallet
  ```console
     $ cd vision-wallet-client
     $ ./gradlew build
     $ cd build/libs
     $ java -jar vision-wallet-client.jar -c
     ```      

### Connect to java-vision-core

vision-wallet-client connect to java-vision-core via gRPC protocol, which can be deployed locally or remotely. Check **Run a web Wallet** section.
We can configure java-vision-core node IP and port in ``src/main/resources/config.conf``, so that vision-wallet-client server can successfully talk to java-vision-core nodes.

## vision-wallet-client supported command list

Following is a list of Vision vision-wallet-client commands:
For more information on a specific command, just type the command on terminal when you start your Wallet.

| [AddTransactionSign](#How-to-use-the-multi-signature-feature-of-vision-wallet-client) | [ApproveProposal](#Approvecancel-the-proposal)  | [AssetIssue](#How-to-issue-VRC10-tokens) |
| :---------:|:---------:|:--------: |
| [BackupShieldedVRC20Wallet](#How-to-transfer-shielded-VRC20-token) | [BackupWallet](#Wallet-related-commands)| [BackupWallet2Base64](#Wallet-related-commands) |
| [BroadcastTransaction](#Some-others) | [ChangePassword](#Wallet-related-commands)| [CreateProposal](#How-to-initiate-a-proposal) 
| [DeleteProposal](#Cancel-the-created-proposal) | [DeployContract](#How-to-use-smart-contract) | [ExchangeCreate](#How-to-trade-on-the-exchange) |
| [ExchangeInject](#How-to-trade-on-the-exchange) | [ExchangeTransaction](#How-to-trade-on-the-exchange) | [ExchangeWithdraw](#How-to-trade-on-the-exchange) |
| [FreezeBalance](#How-to-delegate-resourcee) | [GenerateAddress](#Account-related-commands) | [GenerateShieldedVRC20Address](#How-to-transfer-shielded-VRC20-token)|
| [GetAccount](#Account-related-commands) |[GetAccountPhoton](#Account-related-commands) | [GetAccountResource](#Account-related-commands) | 
| [GetAddress](#Account-related-commands) | [GetAkFromAsk](#How-to-transfer-shielded-VRC20-token) |[GetAssetIssueByAccount](#How-to-issue-VRC10-tokens) | 
| [GetAssetIssueById](#How-to-issue-VRC10-tokens) | [GetAssetIssueByName](#How-to-issue-VRC10-tokens) |[GetAssetIssueListByName](#How-to-issue-VRC10-tokens) | 
| [GetBalance](#Account-related-commands) | [GetBlock](#How-to-get-block-information) |[GetBlockById](#How-to-get-block-information) | 
| [GetBlockByLatestNum](#How-to-get-block-information) | [GetBlockByLimitNext](#How-to-get-block-information) | [GetBrokerage](#Brokerage) | 
| [GetContract](#How-to-use-smart-contracts) | [GetDelegatedResource](#How-to-delegate-resource) |[GetDelegatedResourceAccountIndex](#How-to-delegate-resource) | 
| [GetDiversifier](#How-to-transfer-shielded-VRC20-token)| [GetExpandedSpendingKey](#How-to-transfer-shielded-VRC20-token)| [GetIncomingViewingKey](#How-to-transfer-shielded-VRC20-token)  | 
| [GetMarketOrderByAccount](#How-to-use-vision-dex-to-sell-asset)| [GetMarketOrderById](#How-to-use-vision-dex-to-sell-asset)| [GetMarketOrderListByPair](#How-to-use-vision-dex-to-sell-asset)  | 
| [GetMarketPairList](#How-to-use-vision-dex-to-sell-asset)| [GetMarketPriceByPair](#How-to-use-vision-dex-to-sell-asset)| [GetNextMaintenanceTime](#Some-others) | 
| [GetNkFromNsk](#How-to-transfer-shielded-VRC20-token) | [GetProposal](#Get-proposal-information) | [GetShieldedPaymentAddress](#How-to-transfer-shielded-VRC20-token)| 
| [GetSpendingKey](#How-to-transfer-shielded-VRC20-token) | [GetReward](#Brokerage) |  [GetTransactionApprovedList](#How-to-use-the-multi-signature-feature-of-vision-wallet-client) |
| [GetTransactionById](#How-to-get-transaction-information) | [GetTransactionCountByBlockNum](#How-to-get-transaction-information) | [GetTransactionInfoByBlockNum](#How-to-get-transaction-information) | 
| [GetTransactionInfoById](#How-to-get-transaction-information) | [GetTransactionSignWeight](#How-to-use-the-multi-signature-feature-of-vision-wallet-client) | [ImportShieldedVRC20Wallet](#How-to-transfer-shielded-VRC20-token) | 
| [ImportWallet](#Wallet-related-commands) | [ImportWalletByBase64](#Wallet-related-commands) | [ListAssetIssue](#Get-Token10) | 
| [ListExchanges](#How-to-trade-on-the-exchange) | [ListExchangesPaginated](#How-to-trade-on-the-exchange) | [ListNodes](#Some-others) | 
| [ListShieldedVRC20Address](#How-to-transfer-shielded-VRC20-token) | [ListShieldedVRC20Note](#How-to-transfer-shielded-VRC20-token) | [ListProposals](#How-to-initiate-a-proposal) | 
| [ListProposalsPaginated](#How-to-initiate-a-proposal) | [ListWitnesses](#Some-others) | [LoadShieldedVRC20Wallet](#How-to-transfer-shielded-VRC20-token) | 
| [Login](#Command-line-operation-flow-example) | [MarketCancelOrder](#How-to-use-vision-dex-to-sell-asset) | [MarketSellAsset](#How-to-use-vision-dex-to-sell-asset)| 
| [ParticipateAssetIssue](#How-to-issue-VRC10-tokens) | [RegisterWallet](#Wallet-related-commands) | [ResetShieldedVRC20Note](#How-to-transfer-shielded-VRC20-token) | 
| [ScanShieldedVRC20NoteByIvk](#How-to-transfer-shielded-VRC20-token) |  [ScanShieldedVRC20NoteByOvk](#How-to-transfer-shielded-VRC20-token) |[SendVS](#How-to-use-the-multi-signature-feature-of-vision-wallet-client) | 
| [SendShieldedVRC20Coin](#How-to-transfer-shielded-VRC20-token) | [SendShieldedVRC20CoinWithoutAsk](#How-to-transfer-shielded-VRC20-token) | [SetShieldedVRC20ContractAddress](#How-to-transfer-shielded-VRC20-token) | 
| [ShowShieldedVRC20AddressInfo](#How-to-transfer-shielded-VRC20-token) | [TransferAsset](#How-to-issue-VRC10-tokens) | [TriggerContract](#How-to-use-smart-contracts) |
| [UnfreezeAsset](#How-to-issue-VRC10-tokens) | [UnfreezeBalance](#How-to-delegate-resource) |[UpdateAsset](#How-to-issue-VRC10-tokens) | 
| [UpdateBrokerage](#Brokerage) | [UpdateEntropyLimit](#How-to-use-smart-contracts) |[UpdateSetting](#How-to-use-smart-contracts) | 
| [UpdateAccountPermission](#How-to-use-the-multi-signature-feature-of-vision-wallet-client) | [VoteWitness](#How-to-vote) |

Type any one of the listed commands, to display how-to tips.

## How to freeze/unfreeze balance

After the funds are frozen, the corresponding number of shares and photon will be obtained.
Shares can be used for voting and photon can be used for trading.
The rules for the use and calculation of share and photon are described later in this article.

**Freeze operation is as follows:**

```console
> freezeBalance [OwnerAddress] frozen_balance frozen_duration [ResourceCode:0 PHOTON, 1 ENTROPY] [receiverAddress]
```

OwnerAddress
> The address of the account that initiated the transaction, optional, default is the address of the login account.

frozen_balance
> The amount of frozen funds, the unit is Vdt.
> The minimum value is **1000000 Vdt(1VS)**.

frozen_duration
> Freeze time, this value is currently only allowed for **3 days**.

For example:

```console
> freezeBalance 100000000 3 1 address
```

After the freeze operation, frozen funds will be transferred from Account Balance to Frozen,
You can view frozen funds from your account information.
After being unfrozen, it is transferred back to Balance by Frozen, and the frozen funds cannot be used for trading.

When more share or photon is needed temporarily, additional funds may be frozen to obtain additional share and photon.
The unfrozen time is postponed until 3 days after the last freeze operation

After the freezing time expires, funds can be unfroze.

**Unfreeze operation is as follows:**

```console
> unfreezeBalance [OwnerAddress] ResourceCode(0 PHOTON, 1 CPU) [receiverAddress]
```

## How to vote

Voting requires share. Share can be obtained by freezing funds.

- The share calculation method is: **1** unit of share can be obtained for every **1VS** frozen.
- After unfreezing, previous vote will expire. You can avoid the invalidation of the vote by re-freezing and voting.

**NOTE** The vision Network only records the status of your last vote, which means that each of your votes will overwrite all previous voting results.

For example:

```console
> freezeBalance 100000000 3 1 address  # Freeze 10VS and acquire 10 units of shares

> votewitness 123455 witness1 4 witness2 6  # Cast 4 votes for witness1 and 6 votes for witness2 at the same time

> votewitness 123455 witness1 10  # Voted 10 votes for witness1
```

The final result of the above command was 10 votes for witness1 and 0 vote for witness2.

## Brokerage

After voting for the witness, you will receive the rewards. The witness has the right to decide the ratio of brokerage. The default ratio is 20%, and the witness can adjust it.

By default, if a witness is rewarded, he will receive 20% of the whole rewards, and 80% of the rewards will be distributed to his voters.

### GetBrokerage

View the ratio of brokerage of the witness.

    > getbrokerage OwnerAddress

OwnerAddress
> The address of the witness's account, it is a base58check type address.

### GetReward

Query unclaimed reward.

    > getreward OwnerAddress

OwnerAddress
> The address of the voter's account, it is a base58check type address.

### UpdateBrokerage

Update the ratio of brokerage, this command is usually used by a witness account.

    > updateBrokerage OwnerAddress brokerage

OwnerAddress
> The address of the witness's account, it is a base58check type address.

brokerage
> The ratio of brokerage you want to update to, the limit of it: 0-100.

For example:

```console
> getbrokerage VkHoxn1142S7t11uks5RdjHGV1pM7wKc  

> getreward  VNUq8EbVBj1y66foK0LCeRSor1zvG4fPTJ

> updateBrokerage VkHoxn1142S7t11uks5RdjHGV1pM7wKc 30
```

## How to calculate photon

The photon calculation rule is:

    constant * FrozenFunds * days

Assuming freeze 1VS（1_000_000 Vdt), 3 days, photon obtained = 1 * 1_000_000 * 3 = 3_000_000.

All contracts consume photon, including transferring, transferring of assets, voting, freezing, etc.
Querying does not consume photon. Each contract needs to consume **100_000 photon**.

If a contract exceeds a certain time (**10s**), this operation does not consume photon.

When the unfreezing operation occurs, the photon is not cleared.
The next time the freeze is performed, the newly added photon is accumulated.

## How to withdraw balance

After each block is produced, the block award is sent to the account's allowance,
and a withdraw operation is allowed every **24 hours** from allowance to balance.
The funds in allowance cannot be locked or traded.

## How to create witness

Applying to become a witness account needs to consume **100_000VS**.
This part of the funds will be burned directly.

## How to create account

It is not allowed to create accounts directly. You can only create accounts by transferring funds to non-existing accounts.
Transferring to a non-existent account has minimum restriction amount of **1VS**.

## Command line operation flow example

```console
$ cd vision-wallet-client
$ ./gradlew build
$ ./gradlew run
> RegisterWallet 123456      (password = 123456)
> login 123456
> getAddress
address = VDJPRPryq15aRsXahj7EK9RozGkMMNTEKu'  # backup it!
> BackupWallet 123456
priKey = 075725cf903fc1f6d6267b8076fc2c6adece0cfd18626c33427d9b2504ea3cef'  # backup it!!! (BackupWallet2Base64 option)
> getbalance
Balance = 0
> AssetIssue TestVS VS 75000000000000000 1 1 2 "2019-10-02 15:10:00" "2020-07-11" "just for test121212" www.test.com 100 100000 10000 10 10000 1
> getaccount VDJPRPryq15aRsXahj7EK9RozGkMMNTEKu
(Print balance: 9999900000
"assetV2": [
    {
        "key": "1000001",
        "value": 74999999999980000
    }
],)
  # (cost VS 1000 VS for assetIssue)
  # (You can query the VS balance and other asset balances for any account )
> TransferAsset VYu0hkQ64GBacfpKCnNkoCir3D9UcRloHH 1000001 10000
```

## How to issue a VRC10 token

Each account can only issue **ONE** VRC10 token.

### Issue VRC10 tokens

    > AssetIssue [OwnerAddress] AssetName AbbrName TotalSupply TrxNum AssetNum Precision StartDate EndDate Description Url FreePhotonLimitPerAccount PublicFreePhotonLimit FrozenAmount0 FrozenDays0 [...] FrozenAmountN FrozenDaysN

OwnerAddress (optional)
> The address of the account which initiated the transaction. 
> Default: the address of the login account.

AssetName
> The name of the issued VRC10 token

AbbrName
> The abbreviation of VRC10 token

TotalSupply
> ​TotalSupply = Account Balance of Issuer + All Frozen Token Amount
> TotalSupply: Total Issuing Amount
> Account Balance Of Issuer: At the time of issuance
> All Frozen Token Amount: Before asset transfer and the issuance

TrxNum, AssetNum
>  These two parameters determine the exchange rate when the token is issued.
> Exchange Rate = TrxNum / AssetNum
> AssetNum: Unit in base unit of the issued token
> TrxNum: Unit in Vdt (0.000001 VS)

Precision
> Precision to how many decimal places  

FreePhotonLimitPerAccount
> The maximum amount of photon each account is allowed to use. Token issuers can freeze VS to obtain photon (TransferAssetContract only)

PublicFreePhotonLimit
> The maximum total amount of photon which is allowed to use for all accounts. Token issuers can freeze VS to obtain photon (TransferAssetContract only)

StartDate, EndDate
> The start and end date of token issuance. Within this period time, other users can participate in token issuance.

FrozenAmount0 FrozenDays0
> Amount and days of token freeze. 
> FrozenAmount0: Must be bigger than 0
> FrozenDays0: Must between 1 and 3653.

Example:

```console
> AssetIssue TestVS VS 75000000000000000 1 1 2 "2019-10-02 15:10:00" "2020-07-11" "just for test121212" www.test.com 100 100000 10000 10 10000 1
> GetAssetIssueByAccount VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK  # View published information
{
    "assetIssue": [
        {
            "owner_address": "VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK",
            "name": "TestVS",
            "abbr": "VS",
            "total_supply": 75000000000000000,
            "frozen_supply": [
                {
                    "frozen_amount": 10000,
                    "frozen_days": 1
                },
                {
                    "frozen_amount": 10000,
                    "frozen_days": 10
                }
            ],
            "vs_num": 1,
            "precision": 2,
            "num": 1,
            "start_time": 1570000200000,
            "end_time": 1594396800000,
            "description": "just for test121212",
            "url": "www.test.com",
            "free_asset_photon_limit": 100,
            "public_free_asset_photon_limit": 100000,
            "id": "1000001"
        }
    ]
}
```

### Update parameters of VRC10 token

    > UpdateAsset [OwnerAddress] newLimit newPublicLimit description url

Specific meaning of the parameters is the same as that of AssetIssue.

Example:

```console
> UpdateAsset 1000 1000000 "change description" www.changetest.com
> GetAssetIssueByAccount VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK  # View the modified information
{
    "assetIssue": [
        {
            "owner_address": "VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK",
            "name": "TestVS",
            "abbr": "VS",
            "total_supply": 75000000000000000,
            "frozen_supply": [
                {
                    "frozen_amount": 10000,
                    "frozen_days": 1
                },
                {
                    "frozen_amount": 10000,
                    "frozen_days": 10
                }
            ],
            "vs_num": 1,
            "precision": 2,
            "num": 1,
            "start_time": 1570000200000,
            "end_time": 1594396800000,
            "description": "change description",
            "url": "www.changetest.com",
            "free_asset_photon_limit": 1000,
            "public_free_asset_photon_limit": 1000000,
            "id": "1000001"
        }
    ]
}
```

### VRC10 token transfer

    > TransferAsset [OwnerAddress] ToAddress AssertID Amount

OwnerAddress (optional)
> The address of the account which initiated the transaction. 
> Default: the address of the login account.

ToAddress
> Address of the target account

AssertName
> VRC10 token ID
> Example: 1000001

Amount
> The number of VRC10 token to transfer

Example:

```console
> TransferAsset VQes8rK7fCj4gpKOf2SqGJc1V61mnkRRTH 1000001 1000
> getaccount VQes8rK7fCj4gpKOf2SqGJc1V61mnkRRTH  # View target account information after the transfer
address: VQes8rK7fCj4gpKOf2SqGJc1V61mnkRRTH
    assetV2
    {
    id: 1000001
    balance: 1000
    latest_asset_operation_timeV2: null
    free_asset_Photon_usageV2: 0
    }
```

### Participating in the issue of VRC10 token

    > ParticipateAssetIssue [OwnerAddress] ToAddress AssetID Amount

OwnerAddress (optional)
> The address of the account which initiated the transaction. 
> Default: the address of the login account.

ToAddress
> Account address of VRC10 issuers

AssertName
> VRC10 token ID
> Example: 1000001

Amount
> The number of VRC10 token to transfers

The participation process must happen during the release of VRC10, otherwise an error may occur.

Example:

```console
> ParticipateAssetIssue VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK 1000001 1000
> getaccount VFaNHPxTFA88MFw6F2tD8QLr7YrRUIOWFG  # View remaining balance
address: VFaNHPxTFA88MFw6F2tD8QLr7YrRUIOWFG
assetV2
    {
    id: 1000001
    balance: 1000
    latest_asset_operation_timeV2: null
    free_asset_photon_usageV2: 0
    }
```

### Unfreeze VRC10 token

To unfreeze all VRC10 token which are supposed to be unfrozen after the freezing period.

    > unfreezeasset [OwnerAddress]

## How to obtain VRC10 token information

ListAssetIssue
> Obtain all of the published VRC10 token information

GetAssetIssueByAccount
> Obtain VRC10 token information based on issuing address

GetAssetIssueById
> Obtain VRC10 token Information based on ID

GetAssetIssueByName
> Obtain VRC10 token Information based on names

GetAssetIssueListByName
> Obtain a list of VRC10 token information based on names

## How to operate with proposal

Any proposal-related operations, except for viewing operations, must be performed by committee members.

### Initiate a proposal

    > createProposal [OwnerAddress] id0 value0 ... idN valueN

OwnerAddress (optional)
> The address of the account which initiated the transaction. 
> Default: the address of the login account.

id0
> The serial number of the parameter. Every parameter of vision network has a serial number. Please refer to "http://visionscan.org/#/sr/committee" 

Value0
> The modified value

In the example, modification No.4 (modifying token issuance fee) costs 1000VS as follows:

```console
> createProposal 4 1000
> listproposals  # View initiated proposal
{
    "proposals": [
        {
            "proposal_id": 1,
            "proposer_address": "VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK",
            "parameters": [
                {
                    "key": 4,
                    "value": 1000
                }
            ],
            "expiration_time": 1567498800000,
            "create_time": 1567498308000
        }
    ]
}
```

The corresponding id is 1.

### Approve / Disapprove a proposal

    > approveProposal [OwnerAddress] id is_or_not_add_approval

OwnerAddress (optional)
> The address of the account which initiated the transaction. 
> Default: the address of the login account.

id
> ID of the initiated proposal
> Example: 1

is_or_not_add_approval
> true for approve; false for disapprove

Example:

```console
> ApproveProposal 1 true  # in favor of the offer
> ApproveProposal 1 false  # Cancel the approved proposal
```

### Delete an existed proposal

    > deleteProposal [OwnerAddress] proposalId

proposalId
> ID of the initiated proposal
> Example: 1

The proposal must be canceled by the supernode that initiated the proposal.

Example：

    > DeleteProposal 1

### Obtain proposal information

ListProposals
> Obtain a list of initiated proposals

ListProposalsPaginated
> Use the paging mode to obtain the initiated proposal

GetProposal
> Obtain proposal information based on the proposal ID

## How to trade on the exchange

The trading and price fluctuations of trading pairs are in accordance with the [Bancor Agreement](https://storage.googleapis.com/website-bancor/2018/04/01ba8253-bancor_protocol_whitepaper_en.pdf),
which can be found in vision's [related documents].

### Create a trading pair

    > exchangeCreate [OwnerAddress] first_token_id first_token_balance second_token_id second_token_balance

OwnerAddress (optional)
> The address of the account which initiated the transaction.
> Default: the address of the login account.

First_token_id, first_token_balance
> ID and amount of the first token

second_token_id, second_token_balance
> ID and amount of the second token
>
> The ID is the ID of the issued VRC10 token. 
> If it is VS, the ID is "_". 
> The amount must be greater than 0, and less than 1,000,000,000,000,000.

Example:

    > exchangeCreate 1000001 10000 _ 10000
    # Create trading pairs with the IDs of 1000001 and VS, with amount 10000 for both.

### Capital injection

    > exchangeInject [OwnerAddress] exchange_id token_id quant

OwnerAddress (optional)
> The address of the account which initiated the transaction.
> Default: the address of the login account.

exchange_id
> The ID of the trading pair to be funded

token_id, quant
> TokenId and quantity (unit in base unit) of capital injection

When conducting a capital injection, depending on its quantity (quant), a proportion
of each token in the trading pair will be withdrawn from the account, and injected into the trading
pair. Depending on the difference in the balance of the transaction, the same amount of money for
the same token would vary.

### Transactions

    > exchangeTransaction [OwnerAddress] exchange_id token_id quant expected

OwnerAddress (optional)
> The address of the account which initiated the transaction.
> Default: the address of the login account.

exchange_id
> ID of the trading pair

token_id, quant
> The ID and quantity of tokens being exchanged, equivalent to selling

expected
> Expected quantity of another token

expected must be less than quant, or an error will be reported.

Example：

    > ExchangeTransaction 1 1000001 100 80

It is expected to acquire the 80 VS by exchanging 1000001 from the trading pair ID of 1, and the amount is 100.(Equivalent to selling an amount of 100 tokenID - 1000001, at a price of 80 VS, in trading pair ID - 1).

### Capital Withdrawal

    > exchangeWithdraw [OwnerAddress] exchange_id token_id quant

OwnerAddress (optional)
> The address of the account which initiated the transaction.
> Default: the address of the login account.

Exchange_id

> 
The ID of the trading pair to be withdrawn

Token_id, quant
> TokenId and quantity (unit in base unit) of capital withdrawal

When conducting a capital withdrawal, depending on its quantity (quant), a proportion of each token
in the transaction pair is withdrawn from the trading pair, and injected into the account. Depending on the difference in the balance of the transaction, the same amount of money for the same token would vary.

### Obtain information on trading pairs

ListExchanges
> List trading pairs

ListExchangesPaginated
> List trading pairs by page

## How to use the multi-signature feature of vision-wallet-client?

Multi-signature allows other users to access the account in order to better manage it. There are
three types of accesses:

- owner: access to the owner of account
- active: access to other features of accounts, and access that authorizes a certain feature. Block production authorization is not included if it's for witness purposes.
- witness: only for witness, block production authorization will be granted to one of the other users.

The rest of the users will be granted

```console
> Updateaccountpermission VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK \
{
  "owner_permission": {
    "type": 0,
    "permission_name": "owner",
    "threshold": 1,
    "keys": [
      {
        "address": "VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK",
        "weight": 1
      }
    ]
  },
  "witness_permission": {
    "type": 1,
    "permission_name": "owner",
    "threshold": 1,
    "keys": [
      {
        "address": "VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK",
        "weight": 1
      }
    ]
  },
  "active_permissions": [
    {
      "type": 2,
      "permission_name": "active12323",
      "threshold": 2,
      "operations": "7fff1fc0033e0000000000000000000000000000000000000000000000000000",
      "keys": [
        {
          "address": "VS52bYSlnQ6OERJlZOSsZEXPZ2vQQu6Ugt",
          "weight": 1
        },
        {
          "address": "VYqlOatZFoCy6WdApyT4Jjph9nWtfTydGH",
          "weight": 1
        }
      ]
    }
  ]
}
```

The account VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK gives the owner access to itself, active access to
VS52bYSlnQ6OERJlZOSsZEXPZ2vQQu6Ugt and VYqlOatZFoCy6WdApyT4Jjph9nWtfTydGH. Active access will
need signatures from both accounts in order to take effect.

If the account is not a witness, it's not necessary to set witness_permission, otherwise an error will occur.

### Signed transaction

    > SendVS VFaNHPxTFA88MFw6F2tD8QLr7YrRUIOWFG 10000000000000000

Will show "Please confirm and input your permission id, if input y or Y means default 0, other
non-numeric characters will cancel transaction."

This will require the transfer authorization of active access. Enter: 2

Then select accounts and put in local password, i.e. VS52bYSlnQ6OERJlZOSsZEXPZ2vQQu6Ugt needs a
private key VS52bYSlnQ6OERJlZOSsZEXPZ2vQQu6Ugt to sign a transaction.

Select another account and enter the local password. i.e. VYqlOatZFoCy6WdApyT4Jjph9nWtfTydGH will
need a private key of VYqlOatZFoCy6WdApyT4Jjph9nWtfTydGH to sign a transaction.

The weight of each account is 1, threshold of access is 2. When the requirements are met, users
will be notified with “Send 10000000000000000 Vdt to VFaNHPxTFA88MFw6F2tD8QLr7YrRUIOWFG
successful !!”.

This is how multiple accounts user multi-signature when using the same cli.
Use the instruction addTransactionSign according to the obtained transaction hex string if
signing at multiple cli. After signing, the users will need to broadcast final transactions
manually.

## Obtain weight information according to transaction

    > getTransactionSignWeight
    0a8c010a020318220860e195d3609c86614096eadec79d2d5a6e080112680a2d747970652e676f6f676c65617069732e636f6d2f70726f746f636f6c2e5472616e73666572436f6e747261637412370a1541a7d8a35b260395c14aa456297662092ba3b76fc01215415a523b449890854c8fc460ab602df9f31fe4293f18808084fea6dee11128027094bcb8bd9d2d1241c18ca91f1533ecdd83041eb0005683c4a39a2310ec60456b1f0075b4517443cf4f601a69788f001d4bc03872e892a5e25c618e38e7b81b8b1e69d07823625c2b0112413d61eb0f8868990cfa138b19878e607af957c37b51961d8be16168d7796675384e24043d121d01569895fcc7deb37648c59f538a8909115e64da167ff659c26101

The information displays as follows:

```json
{
    "result":{
        "code":"PERMISSION_ERROR",
        "message":"Signature count is 2 more than key counts of permission : 1"
    },
    "permission":{
        "operations":"9llll7kc0033e0100000000000000000000000000000000000000000000000000",
        "keys":[
            {
                "address":"VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK",
                "weight":1
            }
        ],
        "threshold":1,
        "id":2,
        "type":"Active",
        "permission_name":"active"
    },
    "transaction":{
        "result":{
            "result":true
        },
        "txid":"93fb90a4abndtmw70zr56xnzdwhkx5bvmb467qalpy3y3wmc4twiwjfspngw99hp",
        "transaction":{
            "signature":[
                "c18ca91f1533ecdd83041eb0005683c4a39a2310ec60456b1f0075b4517443cf4f601a69788f001d4bc03872e892a5e25c618e38e7b81b8b1e69d07823625c2b01",
                "3d61eb0f8868990cfa138b19878e607af957c37b51961d8be16168d7796675384e24043d121d01569895fcc7deb37648c59f538a8909115e64da167ff659c26101"
            ],
            "txID":"93fb90a4abndtmw70zr56xnzdwhkx5bvmb467qalpy3y3wmc4twiwjfspngw99hp",
            "raw_data":{
                "contract":[
                    {
                        "parameter":{
                            "value":{
                                "amount":10000000000000000,
                                "owner_address":"VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK",
                                "to_address":"VFaNHPxTFA88MFw6F2tD8QLr7YrRUIOWFG"
                            },
                            "type_url":"type.googleapis.com/protocol.TransferContract"
                        },
                        "type":"TransferContract",
                        "Permission_id":2
                    }
                ],
                "ref_block_bytes":"0318",
                "ref_block_hash":"60e195d3609c8661",
                "expiration":1554123306262,
                "timestamp":1554101706260
            },
            "raw_data_hex":"0a020318220860e195d3609c86614096eadec79d2d5a6e080112680a2d747970652e676f6f676c65617069732e636f6d2f70726f746f636f6c2e5472616e73666572436f6e747261637412370a1541a7d8a35b260395c14aa456297662092ba3b76fc01215415a523b449890854c8fc460ab602df9f31fe4293f18808084fea6dee11128027094bcb8bd9d2d"
        }
    }
}
```

### Get signature information according to transactions

    > getTransactionApprovedList
    0a8c010a020318220860e195d3609c86614096eadec79d2d5a6e080112680a2d747970652e676f6f676c65617069732e636f6d2f70726f746f636f6c2e5472616e73666572436f6e747261637412370a1541a7d8a35b260395c14aa456297662092ba3b76fc01215415a523b449890854c8fc460ab602df9f31fe4293f18808084fea6dee11128027094bcb8bd9d2d1241c18ca91f1533ecdd83041eb0005683c4a39a2310ec60456b1f0075b4517443cf4f601a69788f001d4bc03872e892a5e25c618e38e7b81b8b1e69d07823625c2b0112413d61eb0f8868990cfa138b19878e607af957c37b51961d8be16168d7796675384e24043d121d01569895fcc7deb37648c59f538a8909115e64da167ff659c26101

```json
{
    "result":{

    },
    "approved_list":[
        "VYqlOatZFoCy6WdApyT4Jjph9nWtfTydGH",
        "VS52bYSlnQ6OERJlZOSsZEXPZ2vQQu6Ugt"
    ],
    "transaction":{
        "result":{
            "result":true
        },
        "txid":"93fb90a4abndtmw70zr56xnzdwhkx5bvmb467qalpy3y3wmc4twiwjfspngw99hp",
        "transaction":{
            "signature":[
                "c18ca91f1533ecdd83041eb0005683c4a39a2310ec60456b1f0075b4517443cf4f601a69788f001d4bc03872e892a5e25c618e38e7b81b8b1e69d07823625c2b01",
                "3d61eb0f8868990cfa138b19878e607af957c37b51961d8be16168d7796675384e24043d121d01569895fcc7deb37648c59f538a8909115e64da167ff659c26101"
            ],
            "txID":"93fb90a4abndtmw70zr56xnzdwhkx5bvmb467qalpy3y3wmc4twiwjfspngw99hp",
            "raw_data":{
                "contract":[
                    {
                        "parameter":{
                            "value":{
                                "amount":10000000000000000,
                                "owner_address":"VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK",
                                "to_address":"VFaNHPxTFA88MFw6F2tD8QLr7YrRUIOWFG"
                            },
                            "type_url":"type.googleapis.com/protocol.TransferContract"
                        },
                        "type":"TransferContract",
                        "Permission_id":2
                    }
                ],
                "ref_block_bytes":"0318",
                "ref_block_hash":"60e195d3609c8661",
                "expiration":1554123306262,
                "timestamp":1554101706260
            },
            "raw_data_hex":"0a020318220860e195d3609c86614096eadec79d2d5a6e080112680a2d747970652e676f6f676c65617069732e636f6d2f70726f746f636f6c2e5472616e73666572436f6e747261637412370a1541a7d8a35b260395c14aa456297662092ba3b76fc01215415a523b449890854c8fc460ab602df9f31fe4293f18808084fea6dee11128027094bcb8bd9d2d"
        }
    }
}
```

## How to use smart contract

### deploy smart contracts

    > DeployContract [ownerAddress] contractName ABI byteCode constructor params isHex fee_limit consume_user_resource_percent origin_entropy_limit value token_value token_id(e.g: VSTOKEN, use # if don't provided) <library:address,library:address,...> <lib_compiler_version(e.g:v5)> library:address,...>

OwnerAddress
> The address of the account that initiated the transaction, optional, default is the address of the login account.

contractName
> Name of smart contract

ABI
> Compile generated ABI code

byteCode
> Compile generated byte code

constructor, params, isHex
> Define the format of the bytecode, which determines the way to parse byteCode from parameters

fee_limit
> Transaction allows for the most consumed VS

consume_user_resource_percent
> Percentage of user resource consumed, in the range [0, 100]

origin_entropy_limit
> The most amount of developer Entropy consumed by trigger contract once

value
> The amount of VS transferred to the contract account

token_value
> Number of VS10

token_id
> VS10 Id

Example:

```
> deployContract normalcontract544 [{"constant":false,"inputs":[{"name":"i","type":"uint256"}],"name": "findArgsByIndexTest","outputs":[{"name":"z","type":"uint256"}],"payable":false,"stateMutability":"nonpayable","type":"function"}]
608060405234801561001057600080fd5b50610134806100206000396000f3006080604052600436106100405763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663329000b58114610045575b600080fd5b34801561005157600080fd5b5061005d60043561006f565b60408051918252519081900360200190f35b604080516003808252608082019092526000916060919060208201838038833901905050905060018160008151811015156100a657fe5b602090810290910101528051600290829060019081106100c257fe5b602090810290910101528051600390829060029081106100de57fe5b6020908102909101015280518190849081106100f657fe5b906020019060200201519150509190505600a165627a7a72305820b24fc247fdaf3644b3c4c94fcee380aa610ed83415061ff9e65d7fa94a5a50a00029 # # false 1000000000 75 50000 0 0 #
```

Get the result of the contract execution with the getTransactionInfoById command:

```console
> getTransactionInfoById 4978dc64ff746ca208e51780cce93237ee444f598b24d5e9ce0da885fb3a3eb9
{
    "id": "8c1f57a5e53b15bb0a0a0a0d4740eda9c31fbdb6a63bc429ec2113a92e8ff361",
    "fee": 6170500,
    "blockNumber": 1867,
    "blockTimeStamp": 1567499757000,
    "contractResult": [
        "6080604052600436106100405763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663329000b58114610045575b600080fd5b34801561005157600080fd5b5061005d60043561006f565b60408051918252519081900360200190f35b604080516003808252608082019092526000916060919060208201838038833901905050905060018160008151811015156100a657fe5b602090810290910101528051600290829060019081106100c257fe5b602090810290910101528051600390829060029081106100de57fe5b6020908102909101015280518190849081106100f657fe5b906020019060200201519150509190505600a165627a7a72305820b24fc247fdaf3644b3c4c94fcee380aa610ed83415061ff9e65d7fa94a5a50a00029"
    ],
    "contract_address": "VyjMkZxPe2CQsLaxxeCFLdnpUDsPHsbfTT",
    "receipt": {
        "entropy_fee": 6170500,
        "entropy_usage_total": 61705,
        "photon_usage": 704,
        "result": "SUCCESS"
    }
}
```

### trigger smart contarct

    > TriggerContract [ownerAddress] contractAddress method args isHex fee_limit value token_value token_id

OwnerAddress
> The address of the account that initiated the transaction, optional, default is the address of the login account.

contractAddress
> Smart contarct address

method
> The name of function and parameters, please refer to the example

args
> Parameter value

isHex
> The format of the parameters method and args, is hex string or not

fee_limit
> The most amount of VS allows for the consumption

token_value
> Number of VS10

token_id
> VRC10 id, If not, use ‘#’ instead

Example:

```console
> triggerContract Ve33fPsx5c2PVvAtuOIRDCNpraG9r2GsFB findArgsByIndexTest(uint256) 0 false
1000000000 0 0 #
# Get the result of the contract execution with the getTransactionInfoById command
> getTransactionInfoById 7d9c4e765ea53cf6749d8a89ac07d577141b93f83adc4015f0b266d8f5c2dec4
{
    "id": "de289f255aa2cdda95fbd430caf8fde3f9c989c544c4917cf1285a088115d0e8",
    "fee": 8500,
    "blockNumber": 2076,
    "blockTimeStamp": 1567500396000,
    "contractResult": [
        ""
    ],
    "contract_address": "VyjMkZxPe2CQsLaxxeCFLdnpUDsPHsbfTT",
    "receipt": {
        "entropy_fee": 8500,
        "entropy_usage_total": 85,
        "photon_usage": 314,
        "result": "REVERT"
    },
    "result": "FAILED",
    "resMessage": "REVERT opcode executed"
}
```

### get details of a smart contract

    > GetContract contractAddress

contractAddress
> smart contract address

Example:

```console
> GetContract Ve33fPsx5c2PVvAtuOIRDCNpraG9r2GsFB
{
    "origin_address": "VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK",
    "contract_address": "VyjMkZxPe2CQsLaxxeCFLdnpUDsPHsbfTT",
    "abi": {
        "entrys": [
            {
                "name": "findArgsByIndexTest",
                "inputs": [
                    {
                        "name": "i",
                        "type": "uint256"
                    }
                ],
                "outputs": [
                    {
                        "name": "z",
                        "type": "uint256"
                    }
                ],
                "type": "Function",
                "stateMutability": "Nonpayable"
            }
        ]
    },
    "bytecode": "608060405234801561001057600080fd5b50610134806100206000396000f3006080604052600436106100405763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663329000b58114610045575b600080fd5b34801561005157600080fd5b5061005d60043561006f565b60408051918252519081900360200190f35b604080516003808252608082019092526000916060919060208201838038833901905050905060018160008151811015156100a657fe5b602090810290910101528051600290829060019081106100c257fe5b602090810290910101528051600390829060029081106100de57fe5b6020908102909101015280518190849081106100f657fe5b906020019060200201519150509190505600a165627a7a72305820b24fc247fdaf3644b3c4c94fcee380aa610ed83415061ff9e65d7fa94a5a50a00029",
    "consume_user_resource_percent": 75,
    "name": "normalcontract544",
    "origin_entropy_limit": 50000,
    "code_hash": "23423cece3b4866263c15357b358e5ac261c218693b862bcdb90fa792d5714e6"
}
```

### update smart contract parameters

    > UpdateEntropyLimit [ownerAddress] contract_address entropy_limit  # Update parameter entropy_limit
    > UpdateSetting [ownerAddress] contract_address consume_user_resource_percent  # Update parameter consume_user_resource_percent

## How to delegate resource

### delegate resource

    > freezeBalance [OwnerAddress] frozen_balance frozen_duration [ResourceCode:0 PHOTON, 1 ENTROPY] [receiverAddress]

The latter two parameters are optional parameters. If not set, the VS is frozen to obtain
resources for its own use; if it is not empty, the acquired resources are used by receiverAddress.

OwnerAddress
> The address of the account that initiated the transaction, optional, default is the address of the login account.

frozen_balance
> The amount of frozen VS, the unit is the smallest unit (Vdt), the minimum is 1000000vdt.

frozen_duration
> frezen duration, 3 days

ResourceCode
> 0 PHOTON;1 ENTROPY

receiverAddress
> target account address

### unfreeze delegated resource

    > unfreezeBalance [OwnerAddress] ResourceCode(0 PHOTON, 1 CPU) [receiverAddress]

The latter two parameters are optional. If they are not set, the PHOTON resource is unfreeze
by default; when the receiverAddress is set, the delegate resources are unfreezed.


### get resource delegation information

getDelegatedResource fromAddress toAddress
> get the information from the fromAddress to the toAddress resource delegate

getDelegatedResourceAccountIndex address
> get the information that address is delegated to other account resources

## Wallet related commands

**RegisterWallet**
> Register your wallet, you need to set the wallet password and generate the address and private key.

**BackupWallet**
> Back up your wallet, you need to enter your wallet password and export the private key.hex string format, such
as: 721d63b074f18d41c147e04c952ec93467777a30b6f16745bc47a8eae5076545

**BackupWallet2Base64**
> Back up your wallet, you need to enter your wallet password and export the private key.base64 format, such as: ch1jsHTxjUHBR+BMlS7JNGd3ejC28WdFvEeo6uUHZUU=

**ChangePassword**
> Modify the password of an account

**ImportWallet**
> Import wallet, you need to set a password, hex String format

**ImportWalletByBase64**
> Import wallet, you need to set a password, base64 fromat

## Account related commands

**GenerateAddress**
> Generate an address and print out the public and private keys

**GetAccount**
> Get account information based on address

**GetAccountPhoton**
> The usage of photon

**GetAccountResource**
> The usage of photon and entropy

**GetAddress**
> Get the address of the current login account

**GetBalance**
> Get the balance of the current login account

## How to get transaction information

**GetTransactionById**
> Get transaction information based on transaction id

**GetTransactionCountByBlockNum**
> Get the number of transactions in the block based on the block height

**GetTransactionInfoById**
> Get transaction-info based on transaction id, generally used to check the result of a smart contract trigger

**GetTransactionInfoByBlockNum**
> Get the list of transaction information in the block based on the block height

## How to get block information

**GetBlock**
> Get the block according to the block number; if you do not pass the parameter, get the latest block

**GetBlockById**
> Get block based on blockID

**GetBlockByLatestNum n**
> Get the latest n blocks, where 0 < n < 100

**GetBlockByLimitNext startBlockId endBlockId**
> Get the block in the range [startBlockId, endBlockId)

## Some others

**GetNextMaintenanceTime**
> Get the start time of the next maintain period

**ListNodes**
> Get other peer information

**ListWitnesses**
> Get all miner node information

**BroadcastTransaction**
> Broadcast the transaction, where the transaction is in hex string format.

<!--  
## How to transfer to shielded address

### loadshieldedwallet

Load shielded address, shielded note and start to scan by ivk

Example:

```console
> loadshieldedwallet
Please input your password for shielded wallet.
> *******
LoadShieldedWallet successful !!!
```

### generateshieldedaddress number

Generate shielded addresses

number
> The number of shielded addresses, the default is 1

Example:

```console
> generateshieldedaddress 2
ShieldedAddress list:
zvision165vh2d0qqj7ytrkjeehwy0sg3uvc4tnvcqnpqnzrqq4jpw2p7pzgm2d3chrwxk2jf9ck6rza8jr
zvision1klw4nge0dz45axsyf5rq4tujmwernmwzzlq3s5wly3tewkf8d87zl66xt8seud0jkap2wpwkjcc
GenerateShieldedAddress successful !!
```

### listshieldedaddress

Display cached local shielded address list

Example:

```console
> listshieldedaddress
ShieldedAddress :
zvision1akz7mt4zqsjqrdrwdsmffu6g5dnehhhtahjlc0c6syy3z9nxxjrzqszy22lyx326edmwqjhqe48
zvision1ujhgjxazfnv8gzmkx0djn8cj4ef0mtfec6lkyslnslhf0mxlyg99ptk5hsuxmeqlqyakx7220ar
zvision1vtf8ta7cztkk23pvs7euuh7jw6wzxhqr7pg48zznxt6cxel27ch3t9qhs8npeptdaqvf2sgwqfr
zvision1lpfz287u6q3sfgdmfeh7n7dgmd7lq9780e858jzz0xeqssh0ahcfxg6wmhcqky744adjyk9nc0z
zvision1m5dx50gryu789q5sh5207chzmmgzf5c7hvn8lr6xs60jfxvkv3d3h0kqkglc60rwq26dchztsty
zvision165vh2d0qqj7ytrkjeehwy0sg3uvc4tnvcqnpqnzrqq4jpw2p7pzgm2d3chrwxk2jf9ck6rza8jr
```

### SendShieldedCoin

    > SendShieldedCoin [publicFromAddress] fromAmount shieldedInputNum input publicToAddress toAmount shieldedOutputNum shieldedAddress1 amount1 memo1 ...

Shielded transfer, support from public address or shielded address to public address and shielded address, does not support public address to public address, does not support automatic change.

Public input amount / shielded input amount = public output amount + shielded output amount + fee

publicFromAddress
> Public from address, set to null if not needed. Optional, If this variable is not configured, it is the address of the current login account

fromAmount
> The amount transfer from public address, if publicFromAddress set to null, this variable must be 0.

shieldedInputNum
> The number of shielded input note, should be 0 or 1.

input
> The index of shielded input note, get from execute command listshieldednote, if shieldedInputNum set to 0, no need to set.

publicToAddress
> Public to address, set to null if not needed.

toAmount
> The amount transfer to public address, if publicToAddress set to null, this variable must be 0.

shieldedOutputNum
> The amount of shielded output note. That is the number of (shieldedAddress amount meno) pairs, should be 0, 1, 2

shieldedAddress1
> Output shielded address

amount1
> The amount transfer to shieldedAddress1

memo1
> The memo of this note, up to 512 bytes, can be set to null if not needed

Example:

1. Public address transfer to shielded addresses
    **When in this mode,Some variables must be set as follows, shieldedInputNum=0, publicToAddress=null, toAmount=0**

    ```console
    > sendshieldedcoin VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK 210000000 0 null 0 2 zvision16j06s3p5gvp2jde4vh7w3ug3zz3m62zkyfu86s7ara5lafhp22p9wr3gz0lcdm3pvt7qx0aftu4 100000000 test1 zvision1ghdy60hya8y72deu0q0r25qfl60unmue6889m3xfc3296a5ut6jcyafzhtp9nlutndukufzap4h 100000000 null
    ```

2. shielded address transfer to shielded address
    **When in this mode,Some variables must be set as follows, publicFromAddress=null, fromAmount=0, shieldedInputNum=1,publicToAddress=null,toAmount=0**

    ```console
    > listshieldednote
    Unspend note list like:
    1 zvision1ghdy60hya8y72deu0q0r25qfl60unmue6889m3xfc3296a5ut6jcyafzhtp9nlutndukufzap4h 100000000 4ce5656a13049df00abc7fb3ce78d54c78944d3cbbdfdb29f288e1df5fdf67e1 1 UnSpend
    0 zvision16j06s3p5gvp2jde4vh7w3ug3zz3m62zkyfu86s7ara5lafhp22p9wr3gz0lcdm3pvt7qx0aftu4 100000000 4ce5656a13049df00abc7fb3ce78d54c78944d3cbbdfdb29f288e1df5fdf67e1 0 UnSpend test1

    > sendshieldedcoin null 0 1 0 null 0 1 zvision1hn9r3wmytavslztwmlzvuzk3dqpdhwcmda2d0deyu5pwv32dp78saaslyt82w0078y6uzfg8x6w 90000000 test2
    address zvision16j06s3p5gvp2jde4vh7w3ug3zz3m62zkyfu86s7ara5lafhp22p9wr3gz0lcdm3pvt7qx0aftu4
    ```

3. shielded address transfer to public address
    **When in this mode,Some variables must be set as follows, publicFromAddress=null,fromAmount=0,shieldedInputNum=1,shieldedOutputNum=0**

    ```console
    > listshieldednote
    Unspend note list like:
    1 zvision1ghdy60hya8y72deu0q0r25qfl60unmue6889m3xfc3296a5ut6jcyafzhtp9nlutndukufzap4h 100000000 4ce5656a13049df00abc7fb3ce78d54c78944d3cbbdfdb29f288e1df5fdf67e1 1 UnSpend
    2 zvision1hn9r3wmytavslztwmlzvuzk3dqpdhwcmda2d0deyu5pwv32dp78saaslyt82w0078y6uzfg8x6w 90000000 06b55fc27f7ec649396706d149d18a0bb003347bdd7f489e3d47205da9cee802 0 UnSpend test2

    > sendshieldedcoin null 0 1 2 VmSwWowEZPsSoFwn5wOKJXKrVc7eTQHK 80000000 0
    address zvision1hn9r3wmytavslztwmlzvuzk3dqpdhwcmda2d0deyu5pwv32dp78saaslyt82w0078y6uzfg8x6w
    ```

### sendshieldedcoinwithoutask

Usage and parameters are consistent with the command sendshieldedcoin, the only difference is that sendshieldedcoin uses ask signature, but sendshieldedcoinwithoutask uses ak signature.

### listshieldednote type

List the note scanned by the local cache address

type
> Shows the type of note. If the variable is 0, it shows all unspent notes; For other values, it shows all the notes, including spent notes and unspent notes.

Example:

```console
> listshieldednote 0
Unspend note list like:
1 zvision1ghdy60hya8y72deu0q0r25qfl60unmue6889m3xfc3296a5ut6jcyafzhtp9nlutndukufzap4h 100000000 4ce5656a13049df00abc7fb3ce78d54c78944d3cbbdfdb29f288e1df5fdf67e1 1 UnSpend
listshieldednote 1
All note list like:
zvision1ghdy60hya8y72deu0q0r25qfl60unmue6889m3xfc3296a5ut6jcyafzhtp9nlutndukufzap4h 100000000 4ce5656a13049df00abc7fb3ce78d54c78944d3cbbdfdb29f288e1df5fdf67e1 1 UnSpend
zvision16j06s3p5gvp2jde4vh7w3ug3zz3m62zkyfu86s7ara5lafhp22p9wr3gz0lcdm3pvt7qx0aftu4 100000000 4ce5656a13049df00abc7fb3ce78d54c78944d3cbbdfdb29f288e1df5fdf67e1 0 Spend test1
zvision1hn9r3wmytavslztwmlzvuzk3dqpdhwcmda2d0deyu5pwv32dp78saaslyt82w0078y6uzfg8x6w 90000000 06b55fc27f7ec649396706d149d18a0bb003347bdd7f489e3d47205da9cee802 0 Spend test2
```

### resetshieldednote

Clean all the note scanned, rescanned all blocks.generally used when there is a problem with the notes or when switching environments

### ScanNotebyIvk ivk startNum endNum

Scan notes by ivk

ivk
> The ivk of shielded address

startNum
> The starting block number of the scan

endNum
> The end block number of the scan

Example:

    > scannotebyivk d2a4137cecf049965c4183f78fe9fc9fbeadab6ab3ef70ea749421b4c6b8de04 500 1499

### ScanNotebyOvk ovk startNum endNum

Scan notes by ovk

ovk
> the ivk of shielded address

startNum
> The starting block number of the scan

endNum
> The end block number of the scan

Example:

    > scannotebyovk a5b06ef3067855d741f966d54dfa1c124548535107333336bd9552a427f0529e 500 1499

### GetShieldedNullifier index

Get the nullifier of the note

index
> The note index obtained by the listshieldednote command

Example:

```console
> listshieldednote
Unspend note list like:
2 zvision1ghdy60hya8y72deu0q0r25qfl60unmue6889m3xfc3296a5ut6jcyafzhtp9nlutndukufzap4h 100000000 4ce5656a13049df00abc7fb3ce78d54c78944d3cbbdfdb29f288e1df5fdf67e1 1 UnSpend
getshieldednullifier 2
address zvision1ghdy60hya8y72deu0q0r25qfl60unmue6889m3xfc3296a5ut6jcyafzhtp9nlutndukufzap4h
value 100000000
rcm 07ed5471098652ad441575c61868d1e11317de0f73cbb743a4c5cfe78e3d150c
trxId 4ce5656a13049df00abc7fb3ce78d54c78944d3cbbdfdb29f288e1df5fdf67e1
index 1
memo
ShieldedNullifier:2a524a3be2643365ecdacf8f0d3ca1de8fad3080eea0b9561435b5d1ee467042
```

### ScanAndMarkNotebyAddress shieldedAddress startNum endNum

Scan the note with a locally cached shielded address and mark whether it is spent out

shieldedAddress
> Locally cached shielded address, if it is not a locally cached shielded address, an error will be reported.

startNum
> The starting block number of the scan

endNum
> The end block number of the scan

Example:

    > ScanAndMarkNotebyAddress zvision16j06s3p5gvp2jde4vh7w3ug3zz3m62zkyfu86s7ara5lafhp22p9wr3gz0lcdm3pvt7qx0aftu4 500 1500

### GetSpendingKey

Generate a sk

Example:

```console
> GetSpendingKey
0eb458b309fa544066c40d80ce30a8002756c37d2716315c59a98c893dbb5f6a
```

### getExpandedSpendingKey sk

Generate ask, nsk, ovk from sk

Example:

```console
> getExpandedSpendingKey 0eb458b309fa544066c40d80ce30a8002756c37d2716315c59a98c893dbb5f6a
ask:252a0f6f6f0bac114a13e1e663d51943f1df9309649400218437586dea78260e
nsk:5cd2bc8d9468dbad26ea37c5335a0cd25f110eaf533248c59a3310dcbc03e503
ovk:892a10c1d3e8ea22242849e13f177d69e1180d1d5bba118c586765241ba2d3d6
```

### getAkFromAsk ask
Generate ak from ask

Example:

```console
> GetAkFromAsk 252a0f6f6f0bac114a13e1e663d51943f1df9309649400218437586dea78260e
ak:f1b843147150027daa5b522dd8d0757ec5c8c146defd8e01b62b34cf917299f1
```

### getNkFromNsk nsk

Generate nk from nsk

Example:

```console
> GetNkFromNsk 5cd2bc8d9468dbad26ea37c5335a0cd25f110eaf533248c59a3310dcbc03e503
nk:ed3dc885049f0a716a4de8c08c6cabcad0da3c437202341aa3d9248d8eb2b74a
```

### getIncomingViewingKey ak[64] nk[64]

Generate ivk from ak and nk

Example:

```console
> getincomingviewingkey f1b843147150027daa5b522dd8d0757ec5c8c146defd8e01b62b34cf917299f1 ed3dc885049f0a716a4de8c08c6cabcad0da3c437202341aa3d9248d8eb2b74a
ivk:148cf9e91f1e6656a41dc9b6c6ee4e52ff7a25b25c2d4a3a3182d0a2cd851205
```

### GetDiversifier

Generate a diversifier

Example:

```console
> GetDiversifier
11db4baf6bd5d5afd3a8b5
```

### getshieldedpaymentaddress ivk[64] d[22]

Generate a shielded address from sk and d

Example:

```console
GetShieldedPaymentAddress 148cf9e91f1e6656a41dc9b6c6ee4e52ff7a25b25c2d4a3a3182d0a2cd851205 11db4baf6bd5d5afd3a8b5
pkd:65c11642115d386ed716b9cc06a3498e86e303d7f20d0869c9de90e31322ac15
shieldedAddress:zvision1z8d5htmt6h26l5agk4juz9jzz9wnsmkhz6uucp4rfx8gdccr6leq6zrfe80fpccny2kp2cray8z
```

### BackupShieldedWallet

Back up one shielded address

Example:

```console
wallet> BackUpShieldedWallet
Please input your password for shielded wallet.
password: 
The 1th shielded address is zvision165gswmwecarmyph4x8jfrygezw78tejy3a8y5d9rxnlre7ju5q8jfsfe4qjerhfk0mmkzsx2t6t
The 2th shielded address is zvision1hpd2aau0s55zaauu2dlnnu6umxcqz4wuhflu4p4uqpt9w0nqd88ucf036alw2zjfmclry4tnkf6
The 3th shielded address is zvision19lgz39ja8dz427dt9qa8gpkpxanu05y09zplfzzwc640mlx74n4au3037nde3h6m7zsu5xgkrnn
Please choose between 1 and 3
2
sk:0c2dcfde42a484ecfcf6e7a00a3c9484022674739f405845d8d75fd6d8619153
d :b85aaef78f85282ef79c53
BackupShieldedWallet successful !!!
```

### ImportShieldedWallet

Import one shielded address to local wallet

Example:

```console
wallet> ImportShieldedWallet
Please input your password for shielded wallet.
password: 
Please input shielded wallet hex string. such as 'sk d',Max retry time:3
0b18ba69b7963d2ff47e69ac60c20dc30df34b221fa8960d7d61d68123999b8f  2fd028965d3b455579ab28
Import shielded wallet hex string is : 
sk:0b18ba69b7963d2ff47e69ac60c20dc30df34b221fa8960d7d61d68123999b8f
d :2fd028965d3b455579ab28
Import new shielded wallet address is: zvision19lgz39ja8dz427dt9qa8gpkpxanu05y09zplfzzwc640mlx74n4au3037nde3h6m7zsu5xgkrnn
ImportShieldedWallet successful !!!
wallet> 
```

### ShowShieldedAddressInfo

Display information about shielded addresses

Example:

```console
> listshieldedaddress
ShieldedAddress :
zvision14t95p936cyev678f6l6xsejnyfzrrzfsg56jaxgp7fzxlsczc2l6866fzc4c8awfnrzy74svkrl
zvision1v6tu4c760vs7m0h94t89m4jcxtuq0nxmag7eequc3c2rnee3sufllq8fjtvfff6y84x3zgcapwp
zvision18vaszshuluufz64uesvzw6wtune90uwexzmsfwtgqq2mlydt4fhy0kz02k3vm2j8er7s5xuyujv
> showshieldedaddressinfo zvision18vaszshuluufz64uesvzw6wtune90uwexzmsfwtgqq2mlydt4fhy0kz02k3vm2j8er7s5xuyujv
The following variables are secret information, please don't show to other people!!!
sk :0deebe55fe7e591803126b531d4fe7c0e3979a2fcadb5a7996f73a8e463231f8
ivk:aa955c5798e3f611c72fa22842847810114dd5a860db272b2ef50cc8448ced00
ovk:a1d00b6f761137e1d8b58e77d8685347137131317ba3671f644ffb64bc5baa94
pkd:182769cbe4f257f1d930b704b9680015bf91abaa6e47d84f55a2cdaa47c8fd0a
d  :3b3b0142fcff38916abccc
> showshieldedaddressinfo zvision19lgz39ja8dz427dt9qa8gpkpxanu05y09zplfzzwc640mlx74n4au3037nde3h6m7zsu5xgkrnn
pkd:3a7406c13767c7d08f2883f4884ec6aafdfcdeacebde45f1f4db98df5bf0a1ca
d  :2fd028965d3b455579ab28
```
-->

## How to transfer shielded VRC20 token

If you want to try to transfer shielded VRC20 token, you'd better set the `blockNumberStartToScan` field in `config.conf` file.
This field is used to set the starting block that the wallet needs to scan. If you ignore this field, or set it to 0, 
the notes you receive will probably take a long time to show up in the wallet. It is recommended that this field is 
set to the block number in which the earliest relevant shielded contract was created. If the exact number is not known, 
this field can be set as follows. If used in mainnet, please set 22690588. If used in Nile testnet, please set 6380000. 
Otherwise, please set 0.

When you begin to transfer VRC20 token to shielded address, you must have a shielded address. The
 following commands help to generate shielded account.

### GetSpendingKey

Generate a sk

Example:

```console
> GetSpendingKey
0eb458b309fa544066c40d80ce30a8002756c37d2716315c59a98c893dbb5f6a
```

### GetExpandedSpendingKey

```console
> GetExpandedSpendingKey sk
```
Generate ask, nsk, ovk from sk

Example:

```console
> GetExpandedSpendingKey 0eb458b309fa544066c40d80ce30a8002756c37d2716315c59a98c893dbb5f6a
ask:252a0f6f6f0bac114a13e1e663d51943f1df9309649400218437586dea78260e
nsk:5cd2bc8d9468dbad26ea37c5335a0cd25f110eaf533248c59a3310dcbc03e503
ovk:892a10c1d3e8ea22242849e13f177d69e1180d1d5bba118c586765241ba2d3d6
```

### GetAkFromAsk

```console
> GetAkFromAsk ask
```
Generate ak from ask

Example:

```console
> GetAkFromAsk 252a0f6f6f0bac114a13e1e663d51943f1df9309649400218437586dea78260e
ak:f1b843147150027daa5b522dd8d0757ec5c8c146defd8e01b62b34cf917299f1
```

### GetNkFromNsk

```console
> GetNkFromNsk nsk
```
Generate nk from nsk

Example:

```console
> GetNkFromNsk 5cd2bc8d9468dbad26ea37c5335a0cd25f110eaf533248c59a3310dcbc03e503
nk:ed3dc885049f0a716a4de8c08c6cabcad0da3c437202341aa3d9248d8eb2b74a
```

### GetIncomingViewingKey

```console
> GetIncomingViewingKey ak[64] nk[64]
```
Generate ivk from ak and nk

Example:

```console
> Getincomingviewingkey f1b843147150027daa5b522dd8d0757ec5c8c146defd8e01b62b34cf917299f1
 ed3dc885049f0a716a4de8c08c6cabcad0da3c437202341aa3d9248d8eb2b74a
ivk:148cf9e91f1e6656a41dc9b6c6ee4e52ff7a25b25c2d4a3a3182d0a2cd851205
```

### GetDiversifier

Generate a diversifier

Example:

```console
> GetDiversifier
11db4baf6bd5d5afd3a8b5
```

### GetShieldedPaymentAddress

```console
> GetShieldedPaymentAddress ivk[64] d[22]
```
Generate a shielded address from ivk and d

Example:

```console
> GetShieldedPaymentAddress 148cf9e91f1e6656a41dc9b6c6ee4e52ff7a25b25c2d4a3a3182d0a2cd851205
 11db4baf6bd5d5afd3a8b5
pkd:65c11642115d386ed716b9cc06a3498e86e303d7f20d0869c9de90e31322ac15
shieldedAddress:zvision1z8d5htmt6h26l5agk4juz9jzz9wnsmkhz6uucp4rfx8gdccr6leq6zrfe80fpccny2kp2cray8z
```

### SetShieldedVRC20ContractAddress

```console
> SetShieldedVRC20ContractAddress VRC20ContractAddress ShieldedContractAddress
```
VRC20ContractAddress
> VRC20 contract address

ShieldedContractAddress
> Shielded contract address

Set VRC20 contract address and shielded contract address. Please execute this command before you perform all the following operations related to the shielded transaction of VRC20 token except `ScanShieldedVRC20NoteByIvk` and `ScanShieldedVRC20NoteByOvk`.

When you execute this command, the `Scaling Factor` will be shown. The `Scaling Factor` is set in
 the shielded contract. 



Example:

```console
> SetShieldedVRC20ContractAddress VSUwvsIgE1tTtOdJ1hUmlM9cQdYfZvLaKK VsyoRrchSPrvFqbbGxRVOM6wG2KKIObFEE
scalingFactor():ed3437f8
SetShieldedVRC20ContractAddress succeed!
The Scaling Factor is 1000
That means:
No matter you MINT, TRANSFER or BURN, the value must be an integer multiple of 1000
```

### LoadShieldedVRC20Wallet

Load VRC20 shielded address, shielded note and start to scan by ivk.

Example:

```console
> LoadShieldedVRC20Wallet
Please input your password for shieldedVRC20 wallet.
> *******
LoadShieldedVRC20Wallet successful !!!
```

### GenerateShieldedVRC20Address

```console
> GenerateShieldedVRC20Address number
```
number
> The number of VRC20 shielded addresses, the default is 1.

Generate VRC20 shielded addresses.

Example:

```console
> GenerateShieldedVRC20Address 3
ShieldedVRC20Address list:
zvision1da9rnkmnzl89kqq87gzh534xmkdhq9cnm0j39lackskrhflfe9d26chnq3adl86es0jm2098hzc
zvision1mm20lkcpj6tx6jfd6ek5fxkgmpk9f2hda6vxdtkwlzr45ez32wa7dt8uka9xwfqamr7zyk7jpzf
zvision109r3w5gpm0qcf67r67a9ftjt3zy9wmzux4fqgtgcql8gwhcmauv5dm6t9t9x9ht7h3lvs8shxhq
GenerateShieldedVRC20Address successful !!!
```

### ListShieldedVRC20Address

Display cached local VRC20 shielded address list.

Example:

```console
> ListShieldedVRC20Address
ShieldedVRC20Address :
zvision1mm20lkcpj6tx6jfd6ek5fxkgmpk9f2hda6vxdtkwlzr45ez32wa7dt8uka9xwfqamr7zyk7jpzf
zvision109r3w5gpm0qcf67r67a9ftjt3zy9wmzux4fqgtgcql8gwhcmauv5dm6t9t9x9ht7h3lvs8shxhq
zvision1da9rnkmnzl89kqq87gzh534xmkdhq9cnm0j39lackskrhflfe9d26chnq3adl86es0jm2098hzc
zvision1tjgkfk9hgrl0u6d07w3hq0s9jtgq9q64vek3e5l447dmnzhe27yy0ftpee45h07sa092wkrgrjl
zvision15t3c27a5ve43ssflqepa8dke36vzvccxrren4ma2lghu3hle8rtwltufnvvzrm76w042s9p5f46
```

### SendShieldedVRC20Coin

> SendShieldedVRC20Coin fromAmount shieldedInputNum input1 input2 ... publicToAddress toAmount shieldedOutputNum shieldedAddress1 amount1 memo1 shieldedAddress2 amount2 memo2 ....

Shielded transfer, support three types:

- MINT: transfer from one public address to one shielded address, fromAmount should be equal to
 the shielded output amount. When you MINT, you need to enter password twice as prompted, one
 time is for triggering `approve` method of VRC20 contract that allows the shielded contract can
 transfer form your account, and other one is for triggering `mint` method of shielded contract
 that executes MINT. It's important to remember that you must use the same public address to
 trigger these two methods. 
- TRANSFER: transfer from one or two shielded address(es) to one or two shielded address(es), the
 sum of shielded input amount should be equal to the sum of shielded output amount. When you
 TRANSFER, you need to enter password of public account as prompted, and this is used to trigger
 'transfer' method of shielded contract that executes TRANSFER. 
- BURN: transfer from one shielded address to one public address and one optional shielded
 address. If there is no shielded output, toAmount should be equal to the shielded input amount
 , otherwise, the sum of toAmount and shielded output amount should be equal to the shielded
  input amount. When you BURN, you need to enter password of public account as prompted, and
 this is used to trigger 'burn' method of shielded contract that executes BURN. 

It's better to use different accounts to trigger BURN, TRANSFER and MINT.

fromAmount
> The amount transfer from public address. If the transfer type is MINT, this variable must be equal to the shielded output amount, otherwise it must be 0.

shieldedInputNum
> The number of shielded input note, should be 0, 1 or 2. If the transfer type is MINT, this variable must be 0; if BURN, it must be 1.

input1/input2
> The index of shielded input note, get from executing command ListShieldedVRC20Note. If shieldedInputNum set to 0, no need to set.

publicToAddress
> Public to address. If the transfer type is BURN, this variable must be a valid address, otherwise it should be set null.

toAmount
> The amount transfer to public address. If the transfer type is BURN, this variable must be equal to the shielded input amount, otherwise it should be 0.

shieldedOutputNum
> The amount of shielded output note. That is the number of (shieldedAddress amount memo) pairs, should be 0, 1 or 2.

shieldedAddress1/shieldedAddress2
> Output shielded address

amount1/amount2
> The amount transfer to shieldedAddress1/shieldedAddress2

memo1/memo2
> The memo of this note, up to 512 bytes, can be set to null if not needed.

Example:

In this example, the scalingFactor is 1000. 

1. MINT
    
    **In this mode, some variables must be set as follows, shieldedInputNum = 0, publicToAddress = null, toAmount = 0.**

    ```console
    > SendShieldedVRC20Coin 1000000000000 0 null 0 1 zvision15t3c27a5ve43ssflqepa8dke36vzvccxrren4ma2lghu3hle8rtwltufnvvzrm76w042s9p5f46 1000000000000 null
    ```

2. TRANSFER
    
    **In this mode, some variables must be set as follows, fromAmount = 0, publicToAddress = null,toAmount = 0.**

    Transfer from one shielded address to one shielded address.
    ```console
    > ListShieldedVRC20Note
    This command will show all the unspent notes.
    If you want to display all notes, including spent notes and unspent notes, please use command ListShieldedVRC20Note 1
    The unspent note list is shown below:
    9 zvision1tjgkfk9hgrl0u6d07w3hq0s9jtgq9q64vek3e5l447dmnzhe27yy0ftpee45h07sa092wkrgrjl 2000000000000 23f171f6552680b553707715bead8de807a70255c0b091f7e788bf3b59fe3bea 1 UnSpend
    8 zvision15t3c27a5ve43ssflqepa8dke36vzvccxrren4ma2lghu3hle8rtwltufnvvzrm76w042s9p5f46 1000000000000 23f171f6552680b553707715bead8de807a70255c0b091f7e788bf3b59fe3bea 0 UnSpend
    The Scaling Factor is 1000
    No matter you MINT, TRANSFER or BURN, the value must be an integer multiple of 1000
    
    > SendShieldedVRC20Coin 0 1 8 null 0 1 zvision1da9rnkmnzl89kqq87gzh534xmkdhq9cnm0j39lackskrhflfe9d26chnq3adl86es0jm2098hzc 1000000000000 null
    ```

    Transfer from one shielded address to two shielded addresses.
    ```console
    > ListShieldedVRC20Note
    This command will show all the unspent notes.
    If you want to display all notes, including spent notes and unspent notes, please use command ListShieldedVRC20Note 1
    The unspent note list is shown below:
    9 zvision1tjgkfk9hgrl0u6d07w3hq0s9jtgq9q64vek3e5l447dmnzhe27yy0ftpee45h07sa092wkrgrjl 2000000000000 23f171f6552680b553707715bead8de807a70255c0b091f7e788bf3b59fe3bea 1 UnSpend
    10 zvision1da9rnkmnzl89kqq87gzh534xmkdhq9cnm0j39lackskrhflfe9d26chnq3adl86es0jm2098hzc 1000000000000 81a06080f2be3f795c506826e066b9bb5327ca234eb31a0ef2446e11339a3935 0 UnSpend
    The Scaling Factor is 1000
    No matter you MINT, TRANSFER or BURN, the value must be an integer multiple of 1000
    
    > SendShieldedVRC20Coin 0 1 9 null 0 2 zvision1da9rnkmnzl89kqq87gzh534xmkdhq9cnm0j39lackskrhflfe9d26chnq3adl86es0jm2098hzc 1500000000000 test1 zvision1mm20lkcpj6tx6jfd6ek5fxkgmpk9f2hda6vxdtkwlzr45ez32wa7dt8uka9xwfqamr7zyk7jpzf 500000000000 null
    ```

    Transfer from two shielded addresses to one shielded address.
    ```console
    > ListShieldedVRC20Note
    This command will show all the unspent notes.
    If you want to display all notes, including spent notes and unspent notes, please use command ListShieldedVRC20Note 1
    The unspent note list is shown below:
    11 zvision1da9rnkmnzl89kqq87gzh534xmkdhq9cnm0j39lackskrhflfe9d26chnq3adl86es0jm2098hzc 1500000000000 35901973a96369618e5e3f7f4dcede2b5ddb5bc99bf6feac29f2706420ea99c0 0 UnSpend test1
    10 zvision1da9rnkmnzl89kqq87gzh534xmkdhq9cnm0j39lackskrhflfe9d26chnq3adl86es0jm2098hzc 1000000000000 81a06080f2be3f795c506826e066b9bb5327ca234eb31a0ef2446e11339a3935 0 UnSpend
    12 zvision1mm20lkcpj6tx6jfd6ek5fxkgmpk9f2hda6vxdtkwlzr45ez32wa7dt8uka9xwfqamr7zyk7jpzf 500000000000 35901973a96369618e5e3f7f4dcede2b5ddb5bc99bf6feac29f2706420ea99c0 1 UnSpend
    The Scaling Factor is 1000
    No matter you MINT, TRANSFER or BURN, the value must be an integer multiple of 1000    
    
    > SendShieldedVRC20Coin 0 2 10 11 null 0 1 zvision1mm20lkcpj6tx6jfd6ek5fxkgmpk9f2hda6vxdtkwlzr45ez32wa7dt8uka9xwfqamr7zyk7jpzf 2500000000000 null
    ```

    Transfer from two shielded addresses to two shielded addresses.
    ```console
    > ListShieldedVRC20Note
    This command will show all the unspent notes.
    If you want to display all notes, including spent notes and unspent notes, please use command ListShieldedVRC20Note 1
    The unspent note list is shown below:
    13 zvision1mm20lkcpj6tx6jfd6ek5fxkgmpk9f2hda6vxdtkwlzr45ez32wa7dt8uka9xwfqamr7zyk7jpzf 2500000000000 6ec74435e32261a6dfe10f9498b3ab5a5cfede7c4e31299752b449b9506efc11 0 UnSpend
    12 zvision1mm20lkcpj6tx6jfd6ek5fxkgmpk9f2hda6vxdtkwlzr45ez32wa7dt8uka9xwfqamr7zyk7jpzf 500000000000 35901973a96369618e5e3f7f4dcede2b5ddb5bc99bf6feac29f2706420ea99c0 1 UnSpend   
    The Scaling Factor is 1000
    No matter you MINT, TRANSFER or BURN, the value must be an integer multiple of 1000
    
    > SendShieldedVRC20Coin 0 2 12 13 null 0 2 zvision15t3c27a5ve43ssflqepa8dke36vzvccxrren4ma2lghu3hle8rtwltufnvvzrm76w042s9p5f46 1300000000000 null zvision1tjgkfk9hgrl0u6d07w3hq0s9jtgq9q64vek3e5l447dmnzhe27yy0ftpee45h07sa092wkrgrjl 1700000000000 null
    ```

3. BURN 

    **In this mode, some variables must be set as follows, fromAmount = 0, shieldedInputNum = 1.**
    ```console
    > ListShieldedVRC20Note
    This command will show all the unspent notes.
    If you want to display all notes, including spent notes and unspent notes, please use command ListShieldedVRC20Note 1
    The unspent note list is shown below:
    15 zvision1tjgkfk9hgrl0u6d07w3hq0s9jtgq9q64vek3e5l447dmnzhe27yy0ftpee45h07sa092wkrgrjl 1700000000000 7291b2c58cafb4dede626388f12e846470441f9bb05581221fd742bdd8909a24 1 UnSpend
    14 zvision15t3c27a5ve43ssflqepa8dke36vzvccxrren4ma2lghu3hle8rtwltufnvvzrm76w042s9p5f46 1300000000000 7291b2c58cafb4dede626388f12e846470441f9bb05581221fd742bdd8909a24 0 UnSpend
    The Scaling Factor is 1000
    No matter you MINT, TRANSFER or BURN, the value must be an integer multiple of 1000

    > SendShieldedVRC20Coin 0 1 14 TDVr15jvAx6maR28tP7RRpxuKZ38tgsyNE 1300000000000000 0
    > SendShieldedVRC20Coin 0 1 14 TDVr15jvAx6maR28tP7RRpxuKZ38tgsyNE 300000000000000 1 zvision1mm20lkcpj6tx6jfd6ek5fxkgmpk9f2hda6vxdtkwlzr45ez32wa7dt8uka9xwfqamr7zyk7jpzf 1000000000000000 null
    ```

### SendShieldedVRC20CoinWithoutAsk

Usage and parameters are consistent with the command SendShieldedVRC20Coin, the only difference is that SendShieldedVRC20Coin uses ask for signature, but SendShieldedVRC20CoinWithoutAsk uses ak.

### ListShieldedVRC20Note

```console
> ListShieldedVRC20Note type
```
type
> Shows the type of note. If the variable is omitted or set to 0, it shows all unspent notes; For other values, it shows all the notes, including spent notes and unspent notes.

List the note scanned by the local cache address, and the `Scaling Factor`.

**NOTE** When you load shielded wallet, the wallet will scan blocks to find the notes others send to you in the backend. This will take a long time, so when you run `ListShieldedVRC20Note`, your notes will not be displayed immediately.

Example:

```console
> ListShieldedVRC20Note
This command will show all the unspent notes.
If you want to display all notes, including spent notes and unspent notes, please use command ListShieldedVRC20Note 1
The unspent note list is shown below:
15 zvision1tjgkfk9hgrl0u6d07w3hq0s9jtgq9q64vek3e5l447dmnzhe27yy0ftpee45h07sa092wkrgrjl 1700000000000 7291b2c58cafb4dede626388f12e846470441f9bb05581221fd742bdd8909a24 1 UnSpend
The Scaling Factor is 1000
No matter you MINT, TRANSFER or BURN, the value must be an integer multiple of 1000

> ListShieldedVRC20Note 1
All notes are shown below:
zvision1tjgkfk9hgrl0u6d07w3hq0s9jtgq9q64vek3e5l447dmnzhe27yy0ftpee45h07sa092wkrgrjl 1700000000000 7291b2c58cafb4dede626388f12e846470441f9bb05581221fd742bdd8909a24 1 15 UnSpent
zvision15t3c27a5ve43ssflqepa8dke36vzvccxrren4ma2lghu3hle8rtwltufnvvzrm76w042s9p5f46 1000000000000 dc02678b0cf1c93c557dc805edb776fe79201c77f210f08f60cea5d687b14f2e 0 0 Spent
zvision1mm20lkcpj6tx6jfd6ek5fxkgmpk9f2hda6vxdtkwlzr45ez32wa7dt8uka9xwfqamr7zyk7jpzf 1000000000000 e4d35d147762020078d7d197c98fffde181250e4a637d4bdd9ca809116d74131 0 2 Spent
zvision15t3c27a5ve43ssflqepa8dke36vzvccxrren4ma2lghu3hle8rtwltufnvvzrm76w042s9p5f46 1000000000000 1594e1ee06c8420a4f1d80670000cd9268a2ff4e97e3f630909feeb51a9de993 0 3 Spent
zvision15t3c27a5ve43ssflqepa8dke36vzvccxrren4ma2lghu3hle8rtwltufnvvzrm76w042s9p5f46 2000000000000 3f035e966b3ef636ae9c0a0f64bff781b1d1a8b52bab5d8124c0f9162f71f68f 0 1 Spent
zvision1mm20lkcpj6tx6jfd6ek5fxkgmpk9f2hda6vxdtkwlzr45ez32wa7dt8uka9xwfqamr7zyk7jpzf 300000000000 6929757cb86cb6cf3e89df19f3212c3e62070b12d8b36de48e663fed214a4082 0 4 Spent test1
zvision1mm20lkcpj6tx6jfd6ek5fxkgmpk9f2hda6vxdtkwlzr45ez32wa7dt8uka9xwfqamr7zyk7jpzf 2000000000000 e39a1e1d5af7dcbab0d55a63a0c62ec9cc7c0aaf8ce98733802674c3ec1f3a06 0 6 Spent
zvision109r3w5gpm0qcf67r67a9ftjt3zy9wmzux4fqgtgcql8gwhcmauv5dm6t9t9x9ht7h3lvs8shxhq 700000000000 6929757cb86cb6cf3e89df19f3212c3e62070b12d8b36de48e663fed214a4082 1 5 Spent
zvision109r3w5gpm0qcf67r67a9ftjt3zy9wmzux4fqgtgcql8gwhcmauv5dm6t9t9x9ht7h3lvs8shxhq 2300000000000 4ce1ce9f6377ee3cd936757b696ac43ecc39ee6e8a0eab1b8f8ef093e15010f8 0 7 Spent
zvision15t3c27a5ve43ssflqepa8dke36vzvccxrren4ma2lghu3hle8rtwltufnvvzrm76w042s9p5f46 1000000000000 23f171f6552680b553707715bead8de807a70255c0b091f7e788bf3b59fe3bea 0 8 Spent
zvision1tjgkfk9hgrl0u6d07w3hq0s9jtgq9q64vek3e5l447dmnzhe27yy0ftpee45h07sa092wkrgrjl 2000000000000 23f171f6552680b553707715bead8de807a70255c0b091f7e788bf3b59fe3bea 1 9 Spent
zvision1da9rnkmnzl89kqq87gzh534xmkdhq9cnm0j39lackskrhflfe9d26chnq3adl86es0jm2098hzc 1000000000000 81a06080f2be3f795c506826e066b9bb5327ca234eb31a0ef2446e11339a3935 0 10 Spent
zvision1da9rnkmnzl89kqq87gzh534xmkdhq9cnm0j39lackskrhflfe9d26chnq3adl86es0jm2098hzc 1500000000000 35901973a96369618e5e3f7f4dcede2b5ddb5bc99bf6feac29f2706420ea99c0 0 11 Spent test1
zvision1mm20lkcpj6tx6jfd6ek5fxkgmpk9f2hda6vxdtkwlzr45ez32wa7dt8uka9xwfqamr7zyk7jpzf 500000000000 35901973a96369618e5e3f7f4dcede2b5ddb5bc99bf6feac29f2706420ea99c0 1 12 Spent
zvision1mm20lkcpj6tx6jfd6ek5fxkgmpk9f2hda6vxdtkwlzr45ez32wa7dt8uka9xwfqamr7zyk7jpzf 2500000000000 6ec74435e32261a6dfe10f9498b3ab5a5cfede7c4e31299752b449b9506efc11 0 13 Spent
zvision15t3c27a5ve43ssflqepa8dke36vzvccxrren4ma2lghu3hle8rtwltufnvvzrm76w042s9p5f46 1300000000000 7291b2c58cafb4dede626388f12e846470441f9bb05581221fd742bdd8909a24 0 14 Spent
The Scaling Factor is 1000
No matter you MINT, TRANSFER or BURN, the value must be an integer multiple of 1000
```

### ResetShieldedVRC20Note

Clean all the notes scanned, and rescan all blocks. Generally used when there is a problem with the notes or when switching environments.

### ScanShieldedVRC20NoteByIvk

```console
> ScanShieldedVRC20NoteByIvk shieldedVRC20ContractAddress ivk ak nk startNum endNum [event1] [event2] ...
```

shieldedVRC20ContractAddress
> The address of shielded contract

ivk
> The ivk of shielded address

ak
> The ak of shielded address

nk
> The nk of shielded address

startNum
> The starting block number of the scan

endNum
> The end block number of the scan

event1/event2
> The events you want to scan. These events must be compatible with standard events, that is, MintNewLeaf(uint256,bytes32,bytes32,bytes32,bytes32[21]), TransferNewLeaf(uint256,bytes32,bytes32,bytes32,bytes32[21]) and BurnNewLeaf(uint256,bytes32,bytes32,bytes32,bytes32[21]). If you ignore this field, the command will scan the standard events. In most cases, you can ignore these parameters.

Scan notes by ivk, ak and nk.

Example:

```console
> ScanShieldedVRC20NoteByIvk VHhJiOjScyKBSPRpPgG8aYuSx4cXg3GlFG fed8fa4714e6a19511760f9b8ed33388f14c626adff26034f4a21557cb928f01 faf63a2d959df05d4441c0fd42262e0a53629c532e8d29501fe94f9d86c51313 66458c23d737a30146533374d7c5c78f3e05f8f158192e8855493cc55cf8953f 5000 5400
[
    {
        note: {
            value: 100000
            payment_address:
            zvision12dq4ktrydrxzxrsgpmusp4pe0xawqyz4qfxzsgjdauw99n4n3efnw4kmrptlw8jcrrydx5694mw
            rcm: a45878a4e0d53f5cac79370fea1bf4aa82c67d3b2f647ac89c2b1e7061ea740a
            memo: without ask 2v1
        }
        position: 10
        is_spent: true
        tx_id: 5891fd3a8e860b336b7f7d31f64ec52ec5dc76f81b9bb4e4d0fa8a5756a61dd6
    }
]

> ScanShieldedVRC20NoteByIvk VHhJiOjScyKBSPRpPgG8aYuSx4cXg3GlFG fed8fa4714e6a19511760f9b8ed33388f14c626adff26034f4a21557cb928f01  faf63a2d959df05d4441c0fd42262e0a53629c532e8d29501fe94f9d86c51313 66458c23d737a30146533374d7c5c78f3e05f8f158192e8855493cc55cf8953f 5000  6000 MintNewLeaf(uint256,bytes32,bytes32,bytes32,bytes32[21])
[
    {
        note: {
            value: 100000
            payment_address: zvision1z8d5htmt6h26l5agk4ywv86xv3shuv4gjc2rzufyz4s2g5x0035nwrcqmxj4a49n2dy5sq28s5p
            rcm: 07604b4a8018d353c08f93044df0fc04ef988c2f65f9222eacc8d41f0e095404
            memo: mint
        }
        position: 16
        is_spent: false
        tx_id: 38d759216f62503c2b8bf7fc9777e6e25f5f77ec22dd760cc03057c4704277a2
    }
] 

> ScanShieldedVRC20NoteByIvk VHhJiOjScyKBSPRpPgG8aYuSx4cXg3GlFG fed8fa4714e6a19511760f9b8ed33388f14c626adff26034f4a21557cb928f01 faf63a2d959df05d4441c0fd42262e0a53629c532e8d29501fe94f9d86c51313 66458c23d737a30146533374d7c5c78f3e05f8f158192e8855493cc55cf8953f 5000 5400 BurnNewLeaf(uint256,bytes32,bytes32,bytes32,bytes32[21])
[
    {
        note: {
            value: 100000
            payment_address: zvision12dq4ktrydrxzxrsgpmusp4pe0xawqyz4qfxzsgjdauw99n4n3efnw4kmrptlw8jcrrydx5694mw
            rcm: a45878a4e0d53f5cac79370fea1bf4aa82c67d3b2f647ac89c2b1e7061ea740a
            memo: without ask 2v1
        }
        position: 10
        is_spent: true
        tx_id: 5891fd3a8e860b336b7f7d31f64ec52ec5dc76f81b9bb4e4d0fa8a5756a61dd6
    }
]
```

## ScanShieldedVRC20NoteByOvk

```console
> ScanShieldedVRC20NoteByOvk shieldedVRC20ContractAddress ovk startNum endNum [event1] [event2] ...
```
shieldedVRC20ContractAddress
> The address of shielded contract

ovk
> the ovk of shielded address

startNum
> The starting block number of the scan

endNum
> The end block number of the scan

event1/event2
> The event you want to scan. These events must be compatible with standard events, that is, MintNewLeaf(uint256,bytes32,bytes32,bytes32,bytes32[21]), TransferNewLeaf(uint256,bytes32,bytes32,bytes32,bytes32[21]), BurnNewLeaf(uint256,bytes32,bytes32,bytes32,bytes32[21]) and TokenBurn(address,uint256,bytes32[3]). 
If you ignore this field, the command will scan the standard events.

Scan notes by ovk

Example:

```console
> ScanShieldedVRC20NoteByOvk VHhJiOjScyKBSPRpPgG8aYuSx4cXg3GlFG 4b33fc947a53a5e2a1d1636b323f7f6cecff8c34c9fc511ccc7cfaf0dd6f4c03 5000 6000
[
    {
        note: {
            value: 60000
            payment_address: zvision1z8d5htmt6h26l5agk5nlxdlz66fahhcp8vwhyydrwfdajc5yalftew5uhwn6wjz4pwrxu0msu34
            rcm: 50698dc3c97fb4d2c818b62de2265a271eb9a58b5dd65074122ddf4d794c6b03
            memo: 1
        }
        tx_id: 19c8aaa244dbcdf30a4b2a02b9b17054dc5d8ebf41d1f82daea044e65dff29d5
    }
    {
        note: {
            value: 40000
            payment_address: zvision1z8d5htmt6h26l5agk5nlxdlz66fahhcp8vwhyydrwfdajc5yalftew5uhwn6wjz4pwrxu0msu34
            rcm: 94afb02c6fd4b19ada89b6b85e2cc23f2fb76c5188ede646c5046b2539a3bf00
            memo: 2
        }
        tx_id: 19c8aaa244dbcdf30a4b2a02b9b17054dc5d8ebf41d1f82daea044e65dff29d5
    }
    {
        transparent_to_address: TV7ceN4tHDNPB47DMStcUFC3Y8QQ7KzN32
        transparent_amount: 130000
        tx_id: d45da3394be6c15220d31ac17c13e02130aab0c3edf97750620538f4efae366b
    }
]

> ScanShieldedVRC20NoteByOvk VHhJiOjScyKBSPRpPgG8aYuSx4cXg3GlFG 4b33fc947a53a5e2a1d1636b323f7f6cecff8c34c9fc511ccc7cfaf0dd6f4c03 5000 6000  BurnNewLeaf(uint256,bytes32,bytes32,bytes32,bytes32[21])  TokenBurn(address,uint256,bytes32[3])
[
    {
        note: {
            value: 60000
            payment_address: zvision1z8d5htmt6h26l5agk5nlxdlz66fahhcp8vwhyydrwfdajc5yalftew5uhwn6wjz4pwrxu0msu34
            rcm: 50698dc3c97fb4d2c818b62de2265a271eb9a58b5dd65074122ddf4d794c6b03
            memo: 1
        }
        tx_id: 19c8aaa244dbcdf30a4b2a02b9b17054dc5d8ebf41d1f82daea044e65dff29d5
    }
    {
        note: {
            value: 40000
            payment_address: zvision1z8d5htmt6h26l5agk5nlxdlz66fahhcp8vwhyydrwfdajc5yalftew5uhwn6wjz4pwrxu0msu34
            rcm: 94afb02c6fd4b19ada89b6b85e2cc23f2fb76c5188ede646c5046b2539a3bf00
            memo: 2
        }
        tx_id: 19c8aaa244dbcdf30a4b2a02b9b17054dc5d8ebf41d1f82daea044e65dff29d5
    }
    {
        transparent_to_address: TV7ceN4tHDNPB47DMStcUFC3Y8QQ7KzN32
        transparent_amount: 130000
        tx_id: d45da3394be6c15220d31ac17c13e02130aab0c3edf97750620538f4efae366b
    }
]
```

### BackupShieldedVRC20Wallet

Back up one shielded address.

Example:

```console
> BackupShieldedVRC20Wallet
Please input your password for shieldedVRC20 wallet.
password:
The 1th shieldedVRC20 address is zvision1mf0a0cy86j8rmn4l7dcdsnhyj2k46rem4qxwjqh4z0x26utlddtmmr5fk5dchzt2hpujyvgk69z
The 2th shieldedVRC20 address is zvision1mnkdjl0802dqha9ufh4m80f2ua9cff2hct8geeh77llrz4ywgtu0ct8ygy6k5xavdkd278jyttj
The 3th shieldedVRC20 address is zvision1z8d5htmt6h26l5agk5nlxdlz66fahhcp8vwhyydrwfdajc5yalftew5uhwn6wjz4pwrxu0msu34
Please choose between 1 and 3
1
sk:01ef2d71f8eef668e12db7aef1267c7d6a8f43c84dffa66fc09e2c749464190e
d :da5fd7e087d48e3dcebff3
BackupShieldedVRC20Wallet successful !!!
```

### ImportShieldedVRC20Wallet

Import one shielded address to local wallet.

Example:

```console
> ImportShieldedVRC20Wallet
ShieldedVRC20 wallet does not exist, will build it.
Please input password.
password:
Please input password again.
password:
Please input shieldedVRC20 wallet hex string. such as 'sk d',Max retry time:3
0eb458b309fa544066c40d80ce30a8002756c37d2716315c59a98c893dbb000a 11db4baf6bd5d5afd3a8b5
Import shieldedVRC20 wallet hex string is :
sk:0eb458b309fa544066c40d80ce30a8002756c37d2716315c59a98c893dbb000a
d :11db4baf6bd5d5afd3a8b5
Import new shieldedVRC20 wallet address is: zvision1z8d5htmt6h26l5agk5nlxdlz66fahhcp8vwhyydrwfdajc5yalftew5uhwn6wjz4pwrxu0msu34
ImportShieldedVRC20Wallet successfully !!!
```

### ShowShieldedVRC20AddressInfo

```console
> ShowShieldedVRC20AddressInfo address
```
Display information about shielded addresses. If this address is not in the wallet, it will only display `d` and `pkd`

Example:

```console
> ListShieldedVRC20Address
ShieldedVRC20Address :
zvision1mf0a0cy86j8rmn4l7dcdsnhyj2k46rem4qxwjqh4z0x26utlddtmmr5fk5dchzt2hpujyvgk69z
zvision1mnkdjl0802dqha9ufh4m80f2ua9cff2hct8geeh77llrz4ywgtu0ct8ygy6k5xavdkd278jyttj
zvision1z8d5htmt6h26l5agk5nlxdlz66fahhcp8vwhyydrwfdajc5yalftew5uhwn6wjz4pwrxu0msu34

> ShowShieldedVRC20AddressInfo zvision1mf0a0cy86j8rmn4l7dcdsnhyj2k46rem4qxwjqh4z0x26utlddtmmr5fk5dchzt2hpujyvgk69z
The following variables are secret information, please don't show to other people!!!
sk :01ef2d71f8eef668e12db7aef1267c7d6a8f43c84dffa66fc09e2c749464190e
ivk:7d2e9c14ff1d82843f39cb69e8bcc228370e4ea8750669bba79e90c485d94c03
ovk:2c3d164fffa63b41a34f495e0c9d8af79d595cfb07db1539545ddcecf046d66e
pkd:70d84ee492ad5d0f3ba80ce902f513ccad717f6b57bd8e89b51b8b896ab87922
d  :da5fd7e087d48e3dcebff3

> ShowShieldedVRC20AddressInfo zvision1z8d5htmt6h26l5agk8r7wxw9pyhc0a78hl5thva4k9kcn7fsqvygchyt3n2ncy0r4xv4j5mywnu
pkd:c7e719c5092f87f7c7bfe8bbb3b5b16d89f93003088c5c8b8cd53c11e3a99959
d  :11db4baf6bd5d5afd3a8b1
```


## How to use vision-dex to sell asset

### MarketSellAsset

Create an order to sell asset    

> MarketSellAsset owner_address sell_token_id sell_token_quantity buy_token_id buy_token_quantity  
 
ownerAddress
> The address of the account that initiated the transaction

sell_token_id, sell_token_quantity
> ID and amount of the token want to sell

buy_token_id, buy_token_quantity
> ID and amount of the token want to buy

Example: 

```console
MarketSellAsset VFaNHPxTFA88MFw6F2tD8QLr7YrRUIOWFG  1000001 200 _ 100    

Get the result of the contract execution with the getTransactionInfoById command:   
getTransactionInfoById 10040f993cd9452b25bf367f38edadf11176355802baf61f3c49b96b4480d374   

{
	"id": "10040f993cd9452b25bf367f38edadf11176355802baf61f3c49b96b4480d374",
	"blockNumber": 669,
	"blockTimeStamp": 1578983493000,
	"contractResult": [
		""
	],
	"receipt": {
		"photon_usage": 264
	}
} 
```

### GetMarketOrderByAccount

Get the order created by account(just include active status)

> GetMarketOrderByAccount ownerAddress

ownerAddress
> The address of the account that created market order

Example:

```console
GetMarketOrderByAccount VFaNHPxTFA88MFw6F2tD8QLr7YrRUIOWFG   
{
	"orders": [
		{
			"order_id": "fc9c64dfd48ae58952e85f05ecb8ec87f55e19402493bb2df501ae9d2da75db0",
			"owner_address": "VFaNHPxTFA88MFw6F2tD8QLr7YrRUIOWFG",
			"create_time": 1578983490000,
			"sell_token_id": "_",
			"sell_token_quantity": 100,
			"buy_token_id": "1000001",
			"buy_token_quantity": 200,
			"sell_token_quantity_remain": 100
		}
	]
}  
```  

### GetMarketOrderById

Get the specific order by order_id

> GetMarketOrderById orderId

Example:  

```console
GetMarketOrderById fc9c64dfd48ae58952e85f05ecb8ec87f55e19402493bb2df501ae9d2da75db0   
{
	"order_id": "fc9c64dfd48ae58952e85f05ecb8ec87f55e19402493bb2df501ae9d2da75db0",
	"owner_address": "VFaNHPxTFA88MFw6F2tD8QLr7YrRUIOWFG",
	"create_time": 1578983490000,
	"sell_token_id": "_",
	"sell_token_quantity": 100,
	"buy_token_id": "1000001",
	"buy_token_quantity": 200,
}
```

### GetMarketPairList

Get market pair list
   
Example:

```console
GetMarketPairList   
{
	"orderPair": [
		{
			"sell_token_id": "_",
			"buy_token_id": "1000001"
		}
	]
}
```

### GetMarketOrderListByPair

Get order list by pair   

> GetMarketOrderListByPair sell_token_id buy_token_id   

sell_token_id
> ID of the token want to sell      

buy_token_id
> ID of the token want to buy

Example: 

```console
GetMarketOrderListByPair _ 1000001   
{
	"orders": [
		{
			"order_id": "fc9c64dfd48ae58952e85f05ecb8ec87f55e19402493bb2df501ae9d2da75db0",
			"owner_address": "VFaNHPxTFA88MFw6F2tD8QLr7YrRUIOWFG",
			"create_time": 1578983490000,
			"sell_token_id": "_",
			"sell_token_quantity": 100,
			"buy_token_id": "1000001",
			"buy_token_quantity": 200,
			"sell_token_quantity_remain": 100
		}
	]
}
```

### GetMarketPriceByPair

Get market price by pair   

> GetMarketPriceByPair sell_token_id buy_token_id   

sell_token_id
> ID of the token want to sell

buy_token_id
> ID of the token want to buy

Example:   

```console
GetMarketPriceByPair _ 1000001   
{
	"sell_token_id": "_",
	"buy_token_id": "1000001",
	"prices": [
		{
			"sell_token_quantity": 100,
			"buy_token_quantity": 200
		}
	]
}
```

### MarketCancelOrder

Cancel the order   

> MarketCancelOrder owner_address order_id  
 
owner_address
> the account address who have created the order

order_id
> the order id which want to cancel 

Example:   

```console
MarketCancelOrder VFaNHPxTFA88MFw6F2tD8QLr7YrRUIOWFG fc9c64dfd48ae58952e85f05ecb8ec87f55e19402493bb2df501ae9d2da75db0  
```
   
Get the result of the contract execution with the getTransactionInfoById command:  
```console
getTransactionInfoById b375787a098498623403c755b1399e82910385251b643811936d914c9f37bd27   
{
	"id": "b375787a098498623403c755b1399e82910385251b643811936d914c9f37bd27",
	"blockNumber": 1582,
	"blockTimeStamp": 1578986232000,
	"contractResult": [
		""
	],
	"receipt": {
		"photon_usage": 283
	}
}
```
