package TheSecretHistories.Content.Cards.FITIF.Tools;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.TOOL;

public abstract class AbstractTool extends TemplateCustomCard {

    private static final CardColor COLOR = CULT_BLUE;

    public AbstractTool(String id, String imgName, int cost, CardType type, CardRarity rarity, CardTarget target, CardTags principleTag) {
        super(id, imgName, cost, type, COLOR, rarity, target);

        this.principleCount = this.basePrincipleCount = GetDefaultPrincipleCountByRarity(rarity);

        this.principleTag = principleTag;

        this.tags.add(principleTag);
        this.tags.add(TOOL);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        PlayerGainPrinciple();
    }

    private static int GetDefaultPrincipleCountByRarity(CardRarity rarity) {
        switch (rarity) {
            case COMMON:
                return 4;
            case UNCOMMON:
                return 8;
            case RARE:
                return 12;
            default:
                return 0;
        }
    }
}
