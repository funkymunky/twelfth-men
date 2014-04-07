<style type="text/css">
    body {
        padding-top: 60px;
        padding-bottom: 40px;
    }
</style>
    <div class="container">
        <ul class="nav nav-tabs mynav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="/twelfth-men/players">Players</a></li>
            <li><a href="/twelfth-men/matches">Matches</a></li>
            <li><a href="/twelfth-men/draw">Admin</a></li>
        </ul>
    </div>


<script type="text/javascript">
    $(document).ready(function() {
        var pathNode = window.location.pathname.split('/')[2];
        var navListItems = $(".nav-tabs li a");
        navListItems.each(function () {
            $(this).parent().removeClass('active');
            var hrefPath = $(this).attr('href').toLowerCase().split('/')[2];
            if (pathNode.toLowerCase().indexOf(hrefPath) >= 0 ) {
                $(this).parent().addClass('active');
                return false;
            }
        });
    });
</script>