package TheSecretHistories.Content.Cards.Tools;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.TOOL;

public class AbstractTool extends TemplateCustomCard {

    private static final CardColor COLOR = CULT_BLUE;

    protected int principleNumber = 0;

    protected CardTags principleTag;

    public AbstractTool(String id, String imgName, int cost, CardType type, CardRarity rarity, CardTarget target, int principleNumber, CardTags principleTag) {
        super(id, imgName, cost, type, COLOR, rarity, target);

        this.principleNumber = principleNumber;

        this.principleTag = principleTag;

        this.tags.add(principleTag);
        this.tags.add(TOOL);
    }

    public AbstractTool(String id, String imgName, int cost, CardType type, CardTarget target, int principleNumber, CardTags principleTag) {
        this(id, imgName, cost, type, GetRarityByPrincipleNumber(principleNumber), target, principleNumber, principleTag);
    }

    public AbstractTool(String id, String imgName, int cost, CardType type, CardRarity rarity, CardTarget target, CardTags principleTag) {
        this(id, imgName, cost, type, rarity, target, GetPrincipleNumberByRarity(rarity), principleTag);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

    }

    private static CardRarity GetRarityByPrincipleNumber(int principleNumber) {
        switch (principleNumber) {
            case 8:
                return CardRarity.UNCOMMON;
            case 12:
                return CardRarity.RARE;
            case 4:
            default:
                return CardRarity.COMMON;
        }
    }

    private static int GetPrincipleNumberByRarity(CardRarity rarity) {
        switch (rarity) {
            case UNCOMMON:
                return 8;
            case RARE:
                return 12;
            case COMMON:
            default:
                return 4;
        }
    }
}
